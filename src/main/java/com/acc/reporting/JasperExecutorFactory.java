package com.acc.reporting;

public class JasperExecutorFactory {
    // synchronization helper
    private static Object helper = new Object();

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
}
