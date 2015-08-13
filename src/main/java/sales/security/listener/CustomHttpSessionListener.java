package sales.security.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by taras on 30.07.15.
 */
public class CustomHttpSessionListener implements HttpSessionListener {
    final static Logger logger = LoggerFactory.getLogger(CustomHttpSessionListener.class);

    @Autowired
    SessionRegistry sessionRegistry;

    private static int totalActiveSessions;

    public static int getTotalActiveSessions() {
        return totalActiveSessions;
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        logger.info("Session created");
        httpSessionEvent.getSession().setMaxInactiveInterval(30 * 60);
        totalActiveSessions++;
        logger.info("Amount of active session = " + totalActiveSessions);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        logger.info("Session destroyed");
        totalActiveSessions--;
        logger.info("Amount of active session = " + totalActiveSessions);
    }
}
