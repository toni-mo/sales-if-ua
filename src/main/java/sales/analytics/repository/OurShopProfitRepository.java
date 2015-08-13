package sales.analytics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sales.analytics.domain.OurShopProfit;
import sales.analytics.domain.ShopsAnalytic;

import java.util.Date;
import java.util.List;

/**
 * Created by Myroslav on 13.08.2015.
 */
public interface OurShopProfitRepository extends JpaRepository<OurShopProfit, Integer> {
    List<OurShopProfit> findByDateBetween(Date from, Date to);

    List<OurShopProfit> findByDateAfter(Date date);
}
