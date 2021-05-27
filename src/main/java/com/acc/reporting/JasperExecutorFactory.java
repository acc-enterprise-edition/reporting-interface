package com.acc.reporting;

import com.acc.reporting.v2.ReportsExecutor;
import com.acc.reporting.v2.ReportsManager;

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

    // synchronization helper for executor
    private static final Object executorSync = new Object();
    private static volatile ReportsExecutor executorImpl = null;

    public static ReportsExecutor getExecutor() {
        if (executorImpl == null) {
            // synchronized only if we need to create instance
            synchronized(executorSync) {
                if (executorImpl == null) {
                    try {
                        var clazz = (Class<ReportsExecutor>) Class.forName("com.acc.reporting.v2.impl.ReportsExecutorImpl");
                        executorImpl = clazz.getDeclaredConstructor().newInstance();
                    } catch (Exception ex) {
                        throw new RuntimeException("Can not instantiate ReportsExecutor implementation", ex);
                    }
                }
            }
        }
        return executorImpl;
    }

    // synchronization helper for executor
    private static final Object managerSync = new Object();
    private static volatile ReportsManager managerImpl = null;

    public static ReportsManager getManager() {
        if (managerImpl == null) {
            // synchronized only if we need to create instance
            synchronized(managerSync) {
                if (managerImpl == null) {
                    try {
                        var clazz = (Class<ReportsManager>) Class.forName("com.acc.reporting.v2.impl.ReportsManagerImpl");
                        managerImpl = clazz.getDeclaredConstructor().newInstance();
                    } catch (Exception ex) {
                        throw new RuntimeException("Can not instantiate ReportsManager implementation", ex);
                    }
                }
            }
        }
        return managerImpl;
    }

}
