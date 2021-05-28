package com.acc.reporting.v2;

import java.io.InputStream;

public interface ReportsManager {

    /**
     * Read report definition from stream (*.jrxml file),
     * compile it and register within internal cashe
     * Returns true if report registered successfully
     * @param reportStream a stream with report definition  (*.jrxml file)
     * @return             the report name
     */
    boolean registerReport(String uuid, InputStream reportStream);

    boolean containsReport(String uuid);

    boolean removeReport(String uuid);

    /**
     * Read report definition from stream (*.jrxml file),
     * compile it and register within internal cashe with uuid
     * Returns report name, extracted from its definition
     * @param reportStream a stream with report definition  (*.jrxml file)
     * @return             the report name
     */
    ReportBundle compileReport(String uuid, InputStream reportStream);

}
