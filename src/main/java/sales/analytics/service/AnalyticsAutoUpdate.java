package sales.analytics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import sales.analytics.domain.Analytics;
import sales.analytics.repository.AnalyticsRepository;

import java.util.Date;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Myroslav on 30.07.2015.
 */
public class AnalyticsAutoUpdate {
    protected static Logger logger = LoggerFactory.getLogger(AnalyticsAutoUpdate.class.getName());;
    @Autowired
    private AnalyticsService analyticsService;
    private AnalyticsRepository analyticsRepository;

    @Scheduled(cron="50 23 * * * ?")
    public void dailyUpdate()
    {
        Random rand = new Random();
        logger.debug("Daily update" + new Date());
        analyticsRepository.save(new Analytics(100 + rand.nextInt(500), 20000 + rand.nextInt(980000), 100 + rand.nextInt(700), 15 + rand.nextInt(85), new Date()));
    }



}
