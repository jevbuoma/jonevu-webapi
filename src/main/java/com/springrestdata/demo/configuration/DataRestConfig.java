package com.springrestdata.demo.configuration;

import com.springrestdata.demo.model.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

//@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.getExposureConfiguration()
                .forDomainType(User.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(HttpMethod.POST, HttpMethod.DELETE, HttpMethod.PATCH, HttpMethod.PUT)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(HttpMethod.POST, HttpMethod.DELETE, HttpMethod.PATCH, HttpMethod.PUT)));
    }
}
