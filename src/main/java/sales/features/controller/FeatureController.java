package sales.features.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sales.features.domain.Feature;
import sales.features.service.FeatureService;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by volodya on 24.07.15.
 */
@RestController
@RequestMapping("/feature")
public class FeatureController {

    protected static Logger logger = Logger.getLogger(FeatureController.class.getName());

    @Autowired
    private FeatureService service;

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = "application/json; charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public Feature getFeature(@RequestParam(value = "id") int id) {
        logger.info("Feature: get by id using hibernate");
        return service.get(id);
    }

    @RequestMapping(value = "/",
            method = RequestMethod.GET,
            produces = "application/json; charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public List<Feature> getAllFeatures() {
        logger.info("Feature: get all by id using hibernate");
        return service.getAll();
    }

    @RequestMapping(value = "/",
            method = RequestMethod.POST,
            produces = "application/json; charset=UTF-8",
            consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Feature putFeature(@RequestBody Feature feature) {
        logger.info("Feature: save or update using hibernate");
        return service.save(feature);
    }

    @RequestMapping(value = "",
            method = RequestMethod.DELETE,
            produces = "application/json; charset=UTF-8")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeFeature(@RequestParam(value = "id") int id){
        logger.info("Feature: delete using hibernate");
        service.delete(id);
    }


}
