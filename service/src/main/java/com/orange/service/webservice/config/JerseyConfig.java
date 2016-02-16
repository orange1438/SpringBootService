package com.orange.service.webservice.config;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA 14.
 * User: karl.zhao
 * Time: 2016/2/14 0014.
 */

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(){
        packages("com.orange.service.webservice");
        register(JacksonFeature.class);
    }
}
