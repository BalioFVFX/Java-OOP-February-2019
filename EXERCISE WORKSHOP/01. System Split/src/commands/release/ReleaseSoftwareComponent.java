package commands.release;

import commands.base.BaseCommand;
import models.system.System;

public class ReleaseSoftwareComponent extends BaseCommand {

    public ReleaseSoftwareComponent(System system) {
        super(system);
    }

    @Override
    public void execute(String[] data) {
        String hardwareComponentName = data[0];
        String softwareComponentName = data[1];

        getSystem().releaseSoftwareFrom(hardwareComponentName, softwareComponentName);
    }
}
