# reporting-interface

Used in Jasper Reports Server backend module and reporting-module (custom module of Wildfly)

### JasperExecutorFactory 

Factory returns implementation of Instantiator interface.
Implementation is com.acc.reporting.v2.impl.InstantiatorImpl, located in reporting-module.
If implementation not created before, then it created by synchronized block in Thread-safe manner.

### Instantiator

Instantiator is a factory for ReportsExecutor and ReportsManager

### ReportsExecutor execute report and fill it to pdf or excel output stream

### ReportsManager compile and register report's definition