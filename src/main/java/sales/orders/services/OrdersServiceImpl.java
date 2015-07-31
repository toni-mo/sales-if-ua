package sales.orders.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sales.orders.domain.Order;
import sales.orders.repository.OrdersRepository;

import java.util.List;

/**
 * Created by Myroslav on 23.07.2015.
 */

@Service("ordersService")
@Transactional

public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository repository;

    public Order get(int id) {
        return repository.findOne(id);
    }

    public List<Order> getAll(int page, int amount, String field) {
        Sort sort = new Sort(Sort.Direction.ASC, field);
        PageRequest pageRequest = new PageRequest(page, amount, sort);
        return repository.findAll(pageRequest).getContent();
    }

    public int save(Order order) {
        repository.save(order);
        return order.getId();
    }


    public int delete(int id) {
        repository.delete(id);
        return id;
    }

    /*public List<Order> page(int page, int amount, Map<String, String> sort) {
        Page<Order> ordersPage = repository.findAll(new PageRequest(page, amount));
        return ordersPage.getContent();
    }*/

    public List<Order> findByBuyerId(int id) {
        return repository.findByBuyerId(id);
    }

    public List<Order> getAllAsc()
    {
        Sort sort = new Sort(Sort.Direction.ASC, "price");
        return repository.findAll(sort);
    }

    public List<Order> findByPriceGreaterThan(int price) {
        return repository.findByPriceGreaterThan(price);
    }


}
