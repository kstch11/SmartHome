package report;

import java.io.FileWriter;
import java.io.IOException;

public abstract class Reporter<T> implements Report<T> {

    protected FileWriter usageReport = null;
    protected FileWriter houseConfigurationReport = null;
    protected FileWriter journal = null;
    protected static FileWriter eventReport = null;

    public Reporter() {
        try {
            this.usageReport = new FileWriter("src/main/resources/Usage.txt");
            this.houseConfigurationReport = new FileWriter("src/main/resources/HouseConfiguration.txt");
            this.journal = new FileWriter("src/main/resources/Journal.txt");
            eventReport = new FileWriter("src/main/resources/Events.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public abstract void generateReport(T report) throws IOException;

}
