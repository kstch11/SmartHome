package report;

import house.House;
import house.devices.Device;

import java.io.IOException;
import java.util.stream.Collectors;

/**
 * Represents electricity usage report
 */
public class UsageReport extends Reporter<House> {

    private String createUsageReport(House house) {
        return "All electricity consumed by day " + house.reportTotalElectricityConsumption().value() + "\n"
                + house.getAllDevices().stream()
                .map(this::visitDevice).collect(Collectors.joining());
    }

    public String visitDevice(Device device) {
        StringBuilder builder = new StringBuilder("");
        if (device.isElectronicDevice()) {
            builder.append(device.getClass().getSimpleName())
                    .append(" has consumed ")
                    .append(device.getElectricityConsumption()).append(" electricity today. ");
        }
        builder
                .append(device.getClass().getSimpleName())
                .append(" was used ")
                .append(device.usedTimes())
                .append(" times and was broken for ")
                .append(device.brokenTimes())
                .append(" times.\n");
        return builder.toString();
    }

    public void dayReport(int day) throws IOException {
        usageReport.write("_____________________ Day " + day + " _____________________\n");
    }

    public void totalElectricityReport(int electricity) throws IOException {
        usageReport.write("\nTotal electricity consumption " + electricity);
        usageReport.flush();
    }

    @Override
    public void generateReport(House report) throws IOException {
        usageReport.write(createUsageReport(report));

    }
}
