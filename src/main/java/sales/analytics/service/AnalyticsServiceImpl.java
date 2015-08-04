package sales.analytics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import sales.analytics.domain.Analytics;
import sales.analytics.repository.AnalyticsRepository;

import javax.transaction.Transactional;
import java.util.*;
import java.util.logging.Logger;

/**
 * Created by Myroslav on 28.07.2015.
 */

@Service
@Transactional

public class AnalyticsServiceImpl implements AnalyticsService{

    protected static Logger logger = Logger.getLogger(AnalyticsServiceImpl.class.getName());;
    @Autowired
    private AnalyticsRepository analyticsRepository;

    @Override
    public Analytics get(GregorianCalendar date) {
        return analyticsRepository.findByDate(date);
    }

    @Override
    public List<Analytics> getAll() {
        if(tableIsEmpty()) {
            createOnStart();
        }
        return analyticsRepository.findAll();
    }

    @Override
    public Analytics save(Analytics analytics) {
        analyticsRepository.save(analytics);
        return analytics;
    }

    @Override
    public List<Analytics> getByPeriod(Date from, Date to) {
        return analyticsRepository.findByDateBetween(from, to);
    }

    @Override
    public List<Analytics> getAfter(Date date) {
        return analyticsRepository.findByDateAfter(date);
    }

    @Override
    public List<Analytics> getBefore(Date date) {
        return analyticsRepository.findByDateBefore(date);
    }

    public void createOnStart()
    {
        for(int i=180; i>0; i--) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, -i);
            Random rand = new Random();
            analyticsRepository.save(new Analytics(100+rand.nextInt(500), 20000+rand.nextInt(980000), 100 + rand.nextInt(700), 15+rand.nextInt(85), calendar.getTime()));
            logger.info("Fake date added");
        }
    }

    public boolean tableIsEmpty()
    {
        if(analyticsRepository.findAll().size()==0)
        {
            logger.info("Table is empty");
            return true;
        }
        return false;
    }

}
