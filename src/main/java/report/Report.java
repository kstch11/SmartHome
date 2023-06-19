package report;

import java.io.IOException;

/**
 * Default interface for any report in the system.
 */
public interface Report<U> {

    /**
     * Convert this report into text file.
     */
    void generateReport(U report) throws IOException;

}
