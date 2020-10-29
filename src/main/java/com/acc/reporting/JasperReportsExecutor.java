package com.acc.reporting;

import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.HashMap;

public interface JasperReportsExecutor {

    /**
     * Read report definition from stream (*.jrxml file),
     * compile it and register within internal cashe
     * Returns report name, extracted from its definition
     * @param reportStream a stream with report definition  (*.jrxml file)
     * @return             the report name
     */
    String registerReport(InputStream reportStream);

    /**
     * Execute report and fill it to pdf or excel output stream
     * @param reportName name of report from `registerReport`
     * @param parameters named parameters of report
     * @param connection connection to database
     * @param outputType output format (pdf)
     * @return OutputStream with executed and filled report in specified format
     */
    OutputStream execute(String reportName, HashMap<String, Object> parameters, Connection connection, OutputType outputType);

}
