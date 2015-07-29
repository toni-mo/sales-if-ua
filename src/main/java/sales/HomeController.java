package sales;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import sales.goods.domain.Good;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by A on 27.07.2015.
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/")
    public ModelAndView test(HttpServletResponse response) throws IOException
    {   ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }
}
