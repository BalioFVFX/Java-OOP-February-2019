package commands.software.dump;

import commands.base.BaseCommand;
import models.system.System;

public class DumpDestroyCommand extends BaseCommand {
    public DumpDestroyCommand(System system) {
        super(system);
    }

    @Override
    public void execute(String[] data) {
        String hardwareName = data[0];
        getSystem().destroyHardwareByName(hardwareName);
    }
}
