package com.ws.ng.providers;

import com.ws.ng.configuration.ServiceProperties;

import javax.inject.Singleton;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.Properties;

@Singleton
@Provider
public class PropertiesProvider implements ServiceProperties {

    private static final String propertiesFileName = "application.properties";

    public Properties getProperties() {
        final Properties properties = new Properties();
        try {
            properties.load(PropertiesProvider.class.getClassLoader().getResourceAsStream(propertiesFileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

}
