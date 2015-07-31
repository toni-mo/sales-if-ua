package sales.analytics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import sales.analytics.domain.Analytics;
import sales.analytics.repository.AnalyticsRepository;

import java.util.Date;

/**
 * Created by Myroslav on 30.07.2015.
 */
public class AnalyticsAutoUpdate {
    @Autowired
    private AnalyticsService analyticsService;
    private AnalyticsRepository analyticsRepository;

    @Scheduled(cron="50 23 * * * ?")
    public void demoServiceMethod()
    {
        System.out.println("Fake date added");
        analyticsService.save(new Analytics(5, 6000, 10, 15, new Date()));
    }
}
