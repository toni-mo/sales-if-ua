package sales.orders.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sales.orders.domain.Order;
import sales.orders.services.OrdersService;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Myroslav on 23.07.2015.
 */

@RestController
@RequestMapping("/orders")

public class OrdersController {

    protected static Logger logger = Logger.getLogger(OrdersController.class.getName());

    @Autowired
    private OrdersService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")

    public Order getOrders(@PathVariable int id) {
        logger.info("Order: get by id using hibernate");
        return service.get(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")

    public @ResponseBody List<Order> getAllOrders(@RequestParam(value = "page") int page, @RequestParam(value = "amount") int amount) {
        logger.info("Order: get all by id using hibernate");
        return service.getAll(page, amount, "id");
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json; charset=UTF-8", consumes = "application/json")

    public @ResponseBody int addOrders(@RequestBody Order order) throws IOException {
        logger.info("Order: save or update using hibernate");
        return service.save(order);
    }

    @RequestMapping(value = "/searchByBuyer/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Order> searchByUser(@PathVariable int id)
    {
        logger.info("Order: searching by user id");
        return service.findByBuyerId(id);
    }

    @RequestMapping(value = "/sortByPrice", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Order> sortByPrice()
    {
        logger.info("Order: get all orders sorted by ASC");
        return service.getAllAsc();
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody int deleteById(@PathVariable int id)
    {
        logger.info("Order: deleted order with id " + id);
        return service.delete(id);
    }

    @RequestMapping(value = "/priceMoreThan/{price}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Order> filterByPrice(@PathVariable int price)
    {
        logger.info("Order: filter orders by price");
        return service.findByPriceGreaterThan(price);
    }



}
