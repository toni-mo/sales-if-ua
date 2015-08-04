package sales.analytics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sales.analytics.domain.Analytics;
import sales.orders.domain.Order;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Myroslav on 29.07.2015.
 */
public interface AnalyticsRepository extends JpaRepository<Analytics, Integer>{
    Analytics findByDate(GregorianCalendar date);
    List<Analytics> findByDateBetween(Date from, Date to);
    List<Analytics> findByDateAfter(Date date);
    List<Analytics> findByDateBefore(Date date);
}
