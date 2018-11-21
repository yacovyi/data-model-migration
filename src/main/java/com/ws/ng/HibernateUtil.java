package com.ws.ng;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    static final Logger logger = LogManager.getLogger(StatusHandler.class.getName());
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();

            return configuration.configure()
                    .buildSessionFactory();
        } catch (Exception e) {
            logger.error(e);
            throw new RuntimeException(
                    "There was an error building the factory");
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }


}
