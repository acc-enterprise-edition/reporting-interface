package com.acc.reporting.v2;

import java.sql.Connection;
import java.util.Map;

public interface ReportsExecutor {

    /**
     * Execute report and fill it to pdf or excel output stream
     * @param uuid id of report from `registerReport`
     * @param parameters named parameters of report
     * @param connection connection to database
     * @param outputType output format (pdf)
     * @return OutputStream with executed and filled report in specified format
     */
    byte[] executeReport(String uuid, Map<String, String> parameters, Connection connection, ReportOutputType outputType);

}
