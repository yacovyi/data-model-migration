package com.ws.ng.configuration;

import com.ws.ng.StatusHandler;
import org.glassfish.jersey.internal.inject.AbstractBinder;

import javax.inject.Singleton;

public class DependencyBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(ConfigurationProvider.class).to(ConfigurationProvider.class).in(Singleton.class);
        bind(StatusHandler.class).to(StatusHandler.class);
    }
}
