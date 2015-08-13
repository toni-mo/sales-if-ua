package sales.analytics.controller;

import com.wordnik.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sales.analytics.domain.ClientsAnalytic;
import sales.analytics.domain.OurShopProfit;
import sales.analytics.domain.SalesAnalytic;
import sales.analytics.domain.ShopsAnalytic;
import sales.analytics.service.AnalyticsService;
import sales.users.domain.User;

import java.util.Date;
import java.util.List;

/**
 * Created by Myroslav on 29.07.2015.
 */
@Api(basePath = "/analytics", value = "analytics", description = "Endpoint for analytics management")
@RestController
@RequestMapping("/analytics")

public class AnalyticsController {

    protected static Logger logger = LoggerFactory.getLogger(AnalyticsController.class.getName());

    @Autowired
    private AnalyticsService analyticsService;

    @RequestMapping(value = "/clients/range", method = RequestMethod.GET, produces = "application/json")

    public List<ClientsAnalytic> getClientAnalyticsForPeriod(@RequestParam(value = "from") long from, @RequestParam(value = "to") long to) {
        Date fromDate = new Date(from);
        Date toDate = new Date(to);
        logger.info("Get users from " + fromDate + " to " + toDate);
        return analyticsService.getClientsAnalyticForPeriod(fromDate, toDate);
    }

    @RequestMapping(value = "clients/after/{date}", method = RequestMethod.GET, produces = "application/json")

    public List<ClientsAnalytic> getClientsForLastTime(@PathVariable Long date) {
        logger.info("Get users for last time");
        return analyticsService.getClientsAnalyticsForLastTime(new Date(date));
    }

    @RequestMapping(value = "/shops/range", method = RequestMethod.GET, produces = "application/json")

    public List<ShopsAnalytic> getShopsAnalyticsForPeriod(@RequestParam(value = "from") long from, @RequestParam(value = "to") long to) {
        Date fromDate = new Date(from);
        Date toDate = new Date(to);
        logger.info("Get users from " + fromDate + " to " + toDate);
        return analyticsService.getShopsAnalyticForPeriod(fromDate, toDate);
    }

    @RequestMapping(value = "/shops/after/{date}", method = RequestMethod.GET, produces = "application/json")

    public List<ShopsAnalytic> getShopsAnalyticsForLastTime(@PathVariable Long date) {
        logger.info("Get shop analytics for last time");
        return analyticsService.getShopsAnalyticsForLastTime(new Date(date));
    }

    @RequestMapping(value = "sales/shop/{id}/range", method = RequestMethod.GET, produces = "application/json")

    public List<SalesAnalytic> getSalesByShopAndPeriod(@PathVariable Long id, @RequestParam(value = "from") long from, @RequestParam(value = "to") long to) {
        logger.info("Get sales analytics by shop and period");
        Date fromDate = new Date(from);
        Date toDate = new Date(to);
        logger.info("Get users from " + fromDate + " to " + toDate);
        return analyticsService.getAnalyticsByShopForPeriod(id, fromDate, toDate);
    }

    @RequestMapping(value = "sales/shop/{id}/after/{date}", method = RequestMethod.GET, produces = "application/json")

    public List<SalesAnalytic> getSalesByShopForLastTime(@PathVariable Long id, @PathVariable Long date) {
        logger.info("Get sales analytics by shop for last time");
        return analyticsService.getSalesAnalyticForLastTime(id, new Date(date));
    }

    @RequestMapping(value = "/profit/site/after/{date}", method = RequestMethod.GET, produces = "application/json")

    public List<OurShopProfit> getOurShopProfitForLastTime(@PathVariable Long date)
    {
        logger.info("Get our shop profit for last time");
        return analyticsService.getOurShopProfitAfter(new Date(date));
    }

    @RequestMapping(value = "/profit/site/range", method = RequestMethod.GET, produces = "application/json")

    public List<OurShopProfit> getOurShopProfitForPeriod(@RequestParam(value = "from") long from, @RequestParam(value = "to") long to)
    {
        logger.info("Get our shop profit for some period");
        return analyticsService.getOurShopProfitForPeriod(new Date(from), new Date(to));
    }

}

