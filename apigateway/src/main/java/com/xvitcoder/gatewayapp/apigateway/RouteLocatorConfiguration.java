package com.xvitcoder.gatewayapp.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteLocatorConfiguration {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("path_route", r -> r.path("/api/customers/*").uri("http://localhost:8081/api/customers"))
                .route("path_route", r -> r.path("/api/suppliers/*").uri("http://localhost:8082/api/suppliers"))
                .build();
    }
}


///api/customers/1
///api/suppliers/1
///api/combined/2/1

