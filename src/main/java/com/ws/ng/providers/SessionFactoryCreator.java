package com.ws.ng.providers;

import com.ws.ng.StatusHandler;
import com.ws.ng.configuration.ServiceProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.ext.Provider;

@Singleton
@Provider
public class SessionFactoryCreator {

    static final Logger logger = LogManager.getLogger(StatusHandler.class.getName());

    private ServiceProperties serviceProperties;
    @Inject
    public SessionFactoryCreator(ServiceProperties serviceProperties)
    {
        this.serviceProperties = serviceProperties;
    }
    public SessionFactory getSessionFactory() {
        try {
            StandardServiceRegistry standardRegistry =
                    new StandardServiceRegistryBuilder().configure(serviceProperties.getProperties().getProperty("hibernate_filename")).build();
            Metadata metaData =
                    new MetadataSources(standardRegistry).getMetadataBuilder().build();
            return metaData.getSessionFactoryBuilder().build();
        } catch (Throwable th) {
            logger.error(th);
            throw new ExceptionInInitializerError(th);
        }
    }


}
