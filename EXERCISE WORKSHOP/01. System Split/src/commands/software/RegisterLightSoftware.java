package commands.software;

import commands.base.BaseCommand;
import enums.SoftwareType;
import models.software.LightSoftware;
import models.software.Software;
import models.system.System;

public class RegisterLightSoftware extends SoftwareRegister {
    public RegisterLightSoftware(System system) {
        super(system);
    }

    @Override
    public void execute(String[] data) {
        String hardwareComponentName = data[0];
        Software lightSoftware = super.createSoftwareFrom(data, SoftwareType.LIGHT_SOFTWARE);
        getSystem().addSoftwareOnHardware(hardwareComponentName, lightSoftware);
    }
}
