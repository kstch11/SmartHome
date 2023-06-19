package report;

import java.io.IOException;

/**
 * Represents event report
 */
public class EventReport extends Reporter<String> {

    private static EventReport instance = null;

    public static EventReport getInstance() {
        if (instance == null) {
            instance = new EventReport();
        }
        return instance;
    }

    public static void generateEventReport(String event) {
        try {
            eventReport.write(event + "\n");
            eventReport.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void generateReport(String event) {

    }
}
