package com.acc.reporting.v2;

import java.io.InputStream;

public interface ReportsManager {

    /**
     * Read report definition from stream (*.jrxml file),
     * compile it and register within internal cashe
     * Returns true if report registered successfully
     * @param reportStream a stream with report definition  (*.jrxml file)
     * @throws IllegalArgumentException
     */
    void registerReport(String uuid, InputStream reportStream);

    /**
     * Read report definition from stream (*.jrxml file),
     * compile it and register within internal cashe with uuid
     * Returns report name, extracted from its definition
     * @param reportStream a stream with report definition  (*.jrxml file)
     * @return ReportBundle
     * @throws IllegalArgumentException
     */
    ReportBundle compileReport(String uuid, InputStream reportStream);

    void removeReport(String uuid);

    boolean containsReport(String uuid);
}
