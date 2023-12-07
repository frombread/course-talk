package com.example.lastproject.config;

import javax.el.BeanNameResolver;
import javax.websocket.server.ServerEndpointConfig;

public class EndpointConfigurator extends ServerEndpointConfig.Configurator {
    @Override
    public <T> T getEndpointInstance(Class<T> endpointClass) throws InstantiationException {
        return SpringApplicationContext.getBean(endpointClass);
    }
}