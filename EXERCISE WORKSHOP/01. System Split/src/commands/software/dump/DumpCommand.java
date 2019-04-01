package commands.software.dump;

import commands.base.BaseCommand;
import models.system.System;

public class DumpCommand extends BaseCommand {
    public DumpCommand(System system) {
        super(system);
    }

    @Override
    public void execute(String[] data) {
        String hardwareName = data[0];
        super.getSystem().dumpHardwareByName(hardwareName);
    }
}
