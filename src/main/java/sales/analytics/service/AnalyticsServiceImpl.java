package sales.analytics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import sales.analytics.domain.Analytics;
import sales.analytics.repository.AnalyticsRepository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Myroslav on 28.07.2015.
 */

@Service
@Transactional

public class AnalyticsServiceImpl implements AnalyticsService{

    @Autowired
    private AnalyticsRepository analyticsRepository;

    @Override
    public Analytics get(GregorianCalendar date) {
        return analyticsRepository.findByDate(date);
    }

    @Override
    public List<Analytics> getAll() {
        return analyticsRepository.findAll();
    }

    @Override
    public Analytics save(Analytics analytics) {
        analyticsRepository.save(analytics);
        return analytics;
    }

}
