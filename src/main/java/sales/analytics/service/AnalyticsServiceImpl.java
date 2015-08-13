package sales.analytics.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sales.analytics.domain.ClientsAnalytic;
import sales.analytics.domain.OurShopProfit;
import sales.analytics.domain.SalesAnalytic;
import sales.analytics.domain.ShopsAnalytic;
import sales.analytics.repository.ClientsAnalyticsRepository;
import sales.analytics.repository.OurShopProfitRepository;
import sales.analytics.repository.SalesAnalyticsRepository;
import sales.analytics.repository.ShopsAnalyticsRepository;
import sales.roles.service.RoleService;
import sales.users.domain.User;
import sales.users.service.UserService;
import sales.util.Constants;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Myroslav on 28.07.2015.
 */

@Service
@Transactional

public class AnalyticsServiceImpl implements AnalyticsService {
    @Autowired
    private ClientsAnalyticsRepository clientsAnalyticsRepository;

    @Autowired
    private ShopsAnalyticsRepository shopsAnalyticsRepository;

    @Autowired
    private SalesAnalyticsRepository salesAnalyticsRepository;

    @Autowired
    private OurShopProfitRepository ourShopProfitRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    protected static org.slf4j.Logger logger = LoggerFactory.getLogger(AnalyticsServiceImpl.class.getName());

    @Override
    public List<ClientsAnalytic> getClientsAnalyticForPeriod(Date from, Date to) {
        if (IsTableClientsAnalyticsEmpty()) {
            clientsTableAutoGenerate();
        }
        return clientsAnalyticsRepository.findByDateBetween(from, to);
    }

    @Override
    public List<ShopsAnalytic> getShopsAnalyticForPeriod(Date from, Date to) {
        if (IsTableShopsAnalyticsEmpty()) {
            shopsTableAutoGenerate();
        }
        return shopsAnalyticsRepository.findByDateBetween(from, to);
    }

    @Override
    public int getClientsAmountForLastTime(int min) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, -min);
        return userService.findByCreationDateAfterAndRole(calendar.getTime(), roleService.getRoleByValue(Constants.CLIENT)).size();
    }

    @Override
    public int getShopsAmountForLastTime(int min) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, -min);
        return userService.findByCreationDateAfterAndRole(calendar.getTime(), roleService.getRoleByValue(Constants.SHOP)).size();
    }

    @Override
    public List<User> getAllShops() {
        return userService.findByRole(roleService.getRoleByValue(Constants.SHOP));
    }

    @Override
    public List<SalesAnalytic> getAnalyticsByShopForPeriod(Long shopId, Date from, Date to) {
        if (IsTableSalesAnalyticsEmpty()) {
            salesTableAutoGenerate();
        }
        return salesAnalyticsRepository.findByShopAndDateBetween(userService.getById(shopId), from, to);
    }

    @Override
    public List<SalesAnalytic> getSalesAnalyticForLastTime(Long shopId, Date date) {
        if (IsTableSalesAnalyticsEmpty()) {
            salesTableAutoGenerate();
        }
        return salesAnalyticsRepository.findByShopAndDateAfter(userService.getById(shopId), date);
    }

    @Override
    public List<ClientsAnalytic> getClientsAnalyticsForLastTime(Date date) {
        if (IsTableClientsAnalyticsEmpty()) {
            clientsTableAutoGenerate();
        }
        return clientsAnalyticsRepository.findByDateAfter(date);
    }

    @Override
    public List<ShopsAnalytic> getShopsAnalyticsForLastTime(Date date) {
        if (IsTableShopsAnalyticsEmpty()) {
            shopsTableAutoGenerate();
        }
        return shopsAnalyticsRepository.findByDateAfter(date);
    }

    @Override
    public List<OurShopProfit> getOurShopProfitAfter(Date date) {
        if (IsTableOurProfitEmpty()) {
            ourProfitsTableAutoGenerate();
        }
        return ourShopProfitRepository.findByDateAfter(date);
    }

    @Override
    public List<OurShopProfit> getOurShopProfitForPeriod(Date from, Date to) {
        if (IsTableOurProfitEmpty()) {
            ourProfitsTableAutoGenerate();
        }
        return ourShopProfitRepository.findByDateBetween(from, to);
    }

    public void clientsTableAutoGenerate() {
        logger.info("Clients analytics is not found. Generating...");
        for (int i = 180; i > 0; i--) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, -i);
            Random rand = new Random();
            clientsAnalyticsRepository.save(new ClientsAnalytic(10 + rand.nextInt(20), calendar.getTime()));
        }
    }

    public void shopsTableAutoGenerate() {
        logger.info("Shops analytics is not found. Generating...");
        for (int i = 180; i > 0; i--) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, -i);
            Random rand = new Random();
            shopsAnalyticsRepository.save(new ShopsAnalytic(10 + rand.nextInt(10), calendar.getTime()));
        }
    }

    public void salesTableAutoGenerate() {
        logger.info("Sales analytics is not found. Generating...");

        for (int i = 180; i > 0; i--) {
            for (User shop : userService.findByRole(roleService.getRoleByValue(Constants.SHOP))) {
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.DATE, -i);
                Random rand = new Random();
                salesAnalyticsRepository.save(new SalesAnalytic(shop, 10 + rand.nextInt(50), 10000 + rand.nextInt(5000), calendar.getTime()));
            }
        }

    }

    public void ourProfitsTableAutoGenerate() {
        logger.info("Table ourProfit is empty. Generating...");
        for (int i = 6; i > 0; i--) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MONTH, -i);
            Random rand = new Random();
            ourShopProfitRepository.save(new OurShopProfit(10000 + rand.nextInt(5000), calendar.getTime()));
        }

    }

    public boolean IsTableClientsAnalyticsEmpty() {
        if (clientsAnalyticsRepository.findAll().size() == 0) {
            logger.info("Table clientsAnalytic is empty");
            return true;
        }
        return false;
    }

    public boolean IsTableShopsAnalyticsEmpty() {
        if (shopsAnalyticsRepository.findAll().size() == 0) {
            logger.info("Table shopsAnalytics is empty");
            return true;
        }
        return false;
    }

    public boolean IsTableSalesAnalyticsEmpty() {
        if (salesAnalyticsRepository.findAll().size() == 0) {
            logger.info("Table salesAnalytic is empty");
            return true;
        }
        return false;
    }

    public boolean IsTableOurProfitEmpty() {
        if (ourShopProfitRepository.findAll().size() == 0) {
            logger.info("Table ourProfit is empty");
            return true;
        }
        return false;
    }

}
