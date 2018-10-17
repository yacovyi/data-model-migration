package com.ws.ng.configuration;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public interface Config {
    List<String> kafkaBrokers();
}