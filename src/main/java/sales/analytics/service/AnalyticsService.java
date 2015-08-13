package sales.analytics.service;

import sales.analytics.domain.ClientsAnalytic;
import sales.analytics.domain.OurShopProfit;
import sales.analytics.domain.SalesAnalytic;
import sales.analytics.domain.ShopsAnalytic;
import sales.users.domain.User;

import java.util.Date;
import java.util.List;

/**
 * Created by Myroslav on 29.07.2015.
 */
public interface AnalyticsService {

    public List<ClientsAnalytic> getClientsAnalyticForPeriod(Date from, Date to);

    public List<ShopsAnalytic> getShopsAnalyticForPeriod(Date from, Date to);

    public int getClientsAmountForLastTime(int min);

    public int getShopsAmountForLastTime(int min);

    public List<User> getAllShops();

    public List<SalesAnalytic> getAnalyticsByShopForPeriod(Long shop, Date from, Date to);

    public List<SalesAnalytic> getSalesAnalyticForLastTime(Long shop, Date date);

    public List<ClientsAnalytic> getClientsAnalyticsForLastTime(Date date);

    public List<ShopsAnalytic> getShopsAnalyticsForLastTime(Date date);

    public List<OurShopProfit> getOurShopProfitAfter(Date date);

    public List<OurShopProfit> getOurShopProfitForPeriod(Date from, Date to);
}
