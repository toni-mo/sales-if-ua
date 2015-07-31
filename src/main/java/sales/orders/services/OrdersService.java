package sales.orders.services;

import sales.orders.domain.Order;

import java.util.List;

/**
 * Created by Myroslav on 23.07.2015.
 */
public interface OrdersService {
    public Order get(int id);

    public List<Order> getAll(int page, int amount, String field);

    public int save(Order order);

    public int delete(int id);

    public List<Order> findByBuyerId(int id);

    public List<Order> getAllAsc();

    public List<Order> findByPriceGreaterThan(int price);

}
