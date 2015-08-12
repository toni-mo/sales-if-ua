package sales.orders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextLoader;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import sales.orders.services.OrdersService;
import sales.users.domain.User;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by volodya on 12.08.15.
 */
@ContextConfiguration(locations =
        {
                "classpath:META-INF/applicationContext.xml",
                "classpath:test-mvc-servlet.xml"
        },
        loader = ContextLoader.class)
@WebAppConfiguration
public class TestOrderService extends AbstractTestNGSpringContextTests {

    @Autowired
    OrdersService ordersService;

    @Test
    public void testOrdersByUserAndDate()
    {
        User user = new User();
        user.setId((long) 14);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2015);
        cal.set(Calendar.MONTH, 8);
        cal.set(Calendar.DAY_OF_MONTH, 10);
        cal.set(Calendar.HOUR_OF_DAY,12);
        cal.set(Calendar.MINUTE,34);
        cal.set(Calendar.SECOND,41);

        Date date = cal.getTime();

        logger.info(ordersService.getByUserAndDate(user, date).toString());

    }

}
