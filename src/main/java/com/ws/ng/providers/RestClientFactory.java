package com.ws.ng.providers;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

/**
 * This is a basic rest
 */
public class RestClientFactory {
    //TODO should consider making the client instance a singleton and registering an executorService to it

    public static Client newClient() {
        ClientConfig config = getClientConfig();
        Client client = ClientBuilder.newClient(config);
        return client;
    }

    /**
     * This is the place to add new configurations to the rest client
     * similar to the configurations added to the webserver
     *
     * @return org.glassfish.jersey.client.ClientConfig
     */
    protected static ClientConfig getClientConfig() {
        ClientConfig config = new ClientConfig();
        config.register(ObjectMapperProvider.class);
        config.register(JacksonFeature.class);

        //Add filters here

        return config;
    }


}
