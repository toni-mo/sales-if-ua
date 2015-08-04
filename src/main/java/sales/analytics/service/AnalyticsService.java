package sales.analytics.service;

import sales.analytics.domain.Analytics;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Myroslav on 29.07.2015.
 */
public interface AnalyticsService {
    public Analytics get(GregorianCalendar date);

    public List<Analytics> getAll();

    public Analytics save(Analytics analytics);

    public List<Analytics> getByPeriod(Date from, Date to);

    public List<Analytics> getAfter(Date date);

    public List<Analytics> getBefore(Date date);

  /*  public void AnalyticsAutoUpdate();*/

}
