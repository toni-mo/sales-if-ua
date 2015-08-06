package sales.orders.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sales.orders.domain.Order;
import sales.orders.services.OrdersService;
import sales.storage.domain.Storage;
import sales.storage.service.StorageService;
import sales.users.domain.User;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Volodya on 23.07.2015.
 */

@RestController
@RequestMapping("/orders")

public class OrdersController {

    protected static Logger logger = Logger.getLogger(OrdersController.class.getName());

    @Autowired
    private OrdersService service;

    @Autowired
    private StorageService storageService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public Order getOrders(@PathVariable long id) {
        logger.info("Order: get by id using hibernate");
        return service.get(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public List<Order> getAllOrders() {
        logger.info("Order: get all by id using hibernate");
        return service.getAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json; charset=UTF-8", consumes = "application/json")

    public Order addOrders(@RequestBody Order order) throws IOException {
        logger.info("Order: save or update using hibernate");
        return service.save(order);
    }


    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable long id)
    {
        logger.info("Order: deleted order with id " + id);
        service.delete(id);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public List<Order> getUserOrders(@PathVariable long id) {
        logger.info("Order: get all by id using hibernate");
        User user = new User();
        user.setId(id);
        List<Storage> storages= storageService.getStoragesByUser(user);
        return service.getByStorages(storages);
    }

}
