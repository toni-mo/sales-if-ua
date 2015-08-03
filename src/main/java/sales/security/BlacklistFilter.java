package sales.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by taras on 30.07.15.
 */
public class BlacklistFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Retrieve user details
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {

            // If the username is equal to mike, deny access
            if (authentication.getName().equals("mike") == true ) {
                throw new AccessDeniedException("Username and password match. Access denied!");
            }

        }

        // User details are not empty
        filterChain.doFilter(request, response);
    }
}
