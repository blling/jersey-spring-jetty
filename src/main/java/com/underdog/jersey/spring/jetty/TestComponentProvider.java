package com.underdog.jersey.spring.jetty;

import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.internal.inject.InjectionManager;
import org.glassfish.jersey.server.spi.ComponentProvider;

import java.util.Set;

public class TestComponentProvider implements ComponentProvider {
    @Override
    public void initialize(InjectionManager injectionManager) {
        System.out.println("-------------------->TestComponentProvider");

        injectionManager.register(new org.glassfish.hk2.utilities.binding.AbstractBinder() {
            @Override
            protected void configure() {
                bind(GreetingServiceImpl.class).to(GreetingService.class);
            }
        });
    }

    @Override
    public boolean bind(Class<?> component, Set<Class<?>> providerContracts) {
        return false;
    }

    @Override
    public void done() {

    }
}
