package com.acc.reporting;

import com.acc.reporting.v2.Instantiator;

public class JasperExecutorFactory {
    // synchronization helper
    private static final Object helper = new Object();

    private static volatile JasperExecutor implementation = null;

    public static JasperExecutor getImplementation() {
        if (implementation == null) {
            // synchronized only if we need to create instance
            synchronized(helper) {
                if (implementation == null) {
                    try {
                        var clazz = (Class<JasperExecutor>) Class.forName("com.acc.reporting.impl.JasperExecutorImpl");
                        implementation = clazz.getDeclaredConstructor().newInstance();
                    } catch (Exception ex) {
                        throw new RuntimeException("Can not instantiate JasperExecutor implementation", ex);
                    }
                }
            }
        }
        return implementation;
    }

    private static final Object instantiatorSync = new Object();
    private static volatile Instantiator instantiatorImpl = null;

    public static Instantiator getInstantiator() {
        if (instantiatorImpl == null) {
            // synchronized only if we need to create instance
            synchronized(instantiatorSync) {
                if (instantiatorSync == null) {
                    try {
                        var clazz = (Class<Instantiator>) Class.forName("com.acc.reporting.v2.impl.InstantiatorImpl");
                        instantiatorImpl = clazz.getDeclaredConstructor().newInstance();
                    } catch (Exception ex) {
                        throw new RuntimeException("Can not instantiate ReportsExecutor implementation", ex);
                    }
                }
            }
        }
        return instantiatorImpl;
    }

}
