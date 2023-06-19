package house.commands;

import config.HouseContext;
import report.EventReport;

abstract class CommandBase implements Command {

    protected final EventReport eventReport = EventReport.getInstance();

    HouseContext getHouseContext() {
        return HouseContext.getInstance();
    }


}
