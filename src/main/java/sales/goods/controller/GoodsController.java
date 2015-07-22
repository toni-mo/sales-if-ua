package sales.goods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sales.goods.domain.Good;
import sales.goods.service.GoodsService;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;


@RestController
@RequestMapping("/hibernate")
public class GoodsController {

    protected static Logger logger = Logger.getLogger(GoodsController.class.getName());

    @Autowired
    private GoodsService service;

    @RequestMapping(value = "/goods/{id}",
            method = RequestMethod.GET,
            produces = "application/json; charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    Good getGoods(@PathVariable int id) {
        logger.info("Good: get by id using hibernate");
        return service.get(id);
    }

    @RequestMapping(value = "/goods",
            method = RequestMethod.GET,
            produces = "application/json; charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    List<Good> getAllGoods() {
        logger.info("Good: get all by id using hibernate");
        return service.getAll();
    }

    @RequestMapping(value = "/goods",
            method = RequestMethod.POST,
            produces = "application/json; charset=UTF-8",
            consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public
    @ResponseBody
    Good putGoods(@RequestBody Good goods) throws IOException {
        logger.info("Good: save or update using hibernate");
        return service.save(goods);
    }

    @RequestMapping(value = "/goods",
            method = RequestMethod.DELETE,
            produces = "application/json; charset=UTF-8",
            consumes = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public
    @ResponseBody
    void removeGoods(@RequestBody Good goods) throws IOException {
        logger.info("Good: save or update using hibernate");
    }

    @RequestMapping(value = "/goods/page",
            method = RequestMethod.GET,
            produces = "application/json; charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    List<Good> goodsPagination(
            @RequestParam(required = false, value = "number", defaultValue = "0") int page,
            @RequestParam(required = false, value = "amount", defaultValue = "5") int amount) throws IOException {
        logger.info("Good: pagination using hibernate");
        return service.page(page, amount);
    }

    @RequestMapping(value = "/goods/search",
            method = RequestMethod.GET,
            produces = "application/json; charset=UTF-8")
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    List<Good> goodsSearch(@RequestParam(value = "name") String name) throws IOException {
        logger.info("Good: search by name using hibernate");
        return service.searchByName(name);
    }

/*
    @RequestMapping(value = "/goods/asc",
            method = RequestMethod.GET,
            produces = "application/json; charset=UTF-8")
    public
    @ResponseBody
    List<Good> goodsASC(
            @RequestParam(value = "field") String field) throws IOException {
        logger.info("Good: sort by asc using hibernate");
        return dao.sortASC(field);
    }

    @RequestMapping(value = "/goods/desc",
            method = RequestMethod.GET,
            produces = "application/json; charset=UTF-8")
    public
    @ResponseBody
    List<Good> goodsDESC(
            @RequestParam(value = "field") String field) throws IOException {
        logger.info("Good: sort by desc using hibernate");
        return dao.sortDESC(field);
    }

    @RequestMapping(value = "/goods/search/{name}",
            method = RequestMethod.GET,
            produces = "application/json; charset=UTF-8")
    public
    @ResponseBody
    List<Good> goodsSearchByName(
            @PathVariable String name) throws IOException {
        logger.info("Good: search by name using hibernate");
        return dao.search(name);
    }

    @RequestMapping(value = "/goods/search",
            method = RequestMethod.GET,
            produces = "application/json; charset=UTF-8")
    public
    @ResponseBody
    List<Good> goodsSearchPriceBetween(
            @RequestParam(value = "from") int from,
            @RequestParam(value = "to") int to) throws IOException {
        logger.info("Good: search by price using between, using hibernate");
        return dao.searchBetween(from, to);
    }

    @RequestMapping(value = "/goods/search/{name}/scope",
            method = RequestMethod.GET,
            produces = "application/json; charset=UTF-8")
    public
    @ResponseBody
    List<Good> goodsSearchByNameBetweenPrice(
            @PathVariable String name,
            @RequestParam(value = "from") int from,
            @RequestParam(value = "to") int to) throws IOException {
        logger.info("Good: search by price using between, using hibernate");
        return dao.searchByNameWithBetween(name, from, to);
    }*/
}
