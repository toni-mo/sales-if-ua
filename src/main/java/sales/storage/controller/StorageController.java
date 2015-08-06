package sales.storage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sales.goods.domain.Good;
import sales.storage.domain.Storage;
import sales.storage.service.StorageService;
import sales.users.domain.User;

import java.util.List;

/**
 * Created by volodya on 06.08.15.
 */
@RestController
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    StorageService service;

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = "application/json; charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public Storage getStorage(@RequestParam(value = "id") long id) {
        return service.get(id);
    }

    @RequestMapping(value = "/good",
            method = RequestMethod.GET,
            produces = "application/json; charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public List<Storage> getStoragesByGoodId(@RequestParam(value = "id") long id) {
        Good good = new Good();
        good.setId(id);
        return service.getStoragesByGood(good);
    }

    @RequestMapping(value = "/user",
            method = RequestMethod.GET,
            produces = "application/json; charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public List<Storage> getStoragesByUserId(@RequestParam(value = "id") long id) {
        User user = new User();
        user.setId(id);
        return service.getStoragesByUser(user);
    }

}
