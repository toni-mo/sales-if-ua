package sales.users.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sales.notification.service.RegistrationServiceImpl;
import sales.users.domain.User;
import sales.users.service.UserService;

import java.util.List;

/**
 * Created by taras on 29.07.15.
 */
@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/shop")
    public List<User> getAllShops(@RequestParam(required = false, value ="page", defaultValue = "0") int page,
                                  @RequestParam(required = false, value = "amount", defaultValue = "5") int amount,
                                  @RequestParam(required = false, value = "sort", defaultValue = "id") String sortField) {
        logger.debug("Get pageable list of shops");
        return userService.findByRole("shop", page, amount, sortField);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/client")
    public List<User> getAllClients(@RequestParam(required = false, value ="page", defaultValue = "0") int page,
                                    @RequestParam(required = false, value = "amount", defaultValue = "5") int amount,
                                    @RequestParam(required = false, value = "sort", defaultValue = "id") String sortField) {
        logger.debug("Get pageable list of clients");
        return userService.findByRole("client", page, amount, sortField);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/shop/{id}")
    public User getShop(@PathVariable("id") Long id) {
        logger.debug("Get Shop by id");
        return userService.getShop(id);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/client/{id}")
    public User getClient(@PathVariable("id") Long id) {
        logger.debug("Get client by id");
        return userService.getClient(id);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/add",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public User addPerson(@RequestBody User user) {
        logger.debug("Add user");
        return userService.addUser(user);
    }

    @RequestMapping(
            method = RequestMethod.PATCH,
            value = "/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public User updatePerson(@PathVariable("id") Long id, @RequestBody User user) {
        logger.debug("Update User with id = " + id);
        User dbUser = userService.getById(id);

        if(user.getFirstName() != null) dbUser.setFirstName(user.getFirstName());
        if(user.getLastName() != null) dbUser.setLastName(user.getLastName());
        if(user.getAddress() != null) dbUser.setAddress(user.getAddress());
        if(user.getEmail() != null) dbUser.setEmail(user.getEmail());
        if(user.getPhoneNumber() != null) dbUser.setPhoneNumber(user.getPhoneNumber());
        if(user.getPassword() != null) dbUser.setPassword(user.getPassword());

        return userService.addUser(dbUser);
    }


    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteEmployee(@PathVariable("id") Long id) {
        logger.debug("Delete user with id = " + id);
        userService.deleteUser(id);
        return "done";
    }

    @RequestMapping(value = "/shop/{field}={value}",
            method = RequestMethod.GET)
    public List<User> filterShopBy(@PathVariable("field") String searchField,
                              @PathVariable("value") String value,
                              @RequestParam(required = false, value ="page", defaultValue = "0") int page,
                              @RequestParam(required = false, value = "amount", defaultValue = "5") int amount,
                              @RequestParam(required = false, value = "sort", defaultValue = "id") String sortField) {
        logger.debug("Filter Shops by " + searchField + " = " + value);
        return userService.findBy("shop", searchField, value, page, amount, sortField);
    }

    @RequestMapping(value = "/client/{field}={value}",
            method = RequestMethod.GET)
    public List<User> filterClientBy(@PathVariable("field") String searchField,
                              @PathVariable("value") String value,
                              @RequestParam(required = false, value ="page", defaultValue = "0") int page,
                              @RequestParam(required = false, value = "amount", defaultValue = "5") int amount,
                              @RequestParam(required = false, value = "sort", defaultValue = "id") String sortField) {
        logger.debug("Filter Clients by " + searchField + " = " + value);
        return userService.findBy("client" ,searchField, value, page, amount, sortField);
    }

    @RequestMapping(value = "/email")
    public void sendEmail(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("META-INF/bootstrap/email-notification.xml");

        RegistrationServiceImpl mm = (RegistrationServiceImpl) context.getBean("registrationService");
        //mm.register(userService.getByUsername("taras"));
    }
}
