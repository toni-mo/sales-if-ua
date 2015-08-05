package sales.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * Created by taras on 28.07.15.
 */
@Controller
public class LoginController {
    final static Logger logger = LoggerFactory.getLogger(LoginController.class);


    @Resource(name = "sessionRegistry")
    private SessionRegistryImpl sessionRegistry;

    @RequestMapping(
            value = "/#/home")
    public String logged(Model model) {
        logger.debug("Action after successful authorization");
        //sessionRegistry.getAllSessions(SecurityContextHolder.getContext().getAuthentication().getPrincipal(), false);
        model.addAttribute("name", SecurityContextHolder.getContext().getAuthentication().getName());
        return "index";
    }

    @RequestMapping(
            value = "/login/failure")
    public String failure() {
        logger.debug("Action after failed authorization");
        String message = "Login Failure!";
        return "redirect:/login?message="+message;
    }

    @RequestMapping(
            value = "/logout/success")
    public String logout() {
        logger.debug("Action after successful logout");
        String message = "Logout Success!";
        return "redirect:/login?message="+message;
    }
}
