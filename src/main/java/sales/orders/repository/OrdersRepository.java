package sales.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sales.orders.domain.Order;

import java.util.List;

/**
 * Created by Myroslav on 23.07.2015.
 */
public interface OrdersRepository extends JpaRepository<Order, Integer> {
    List<Order> findByBuyerId(int buyer_id);
    List<Order> findByPriceGreaterThan(int price);
}
