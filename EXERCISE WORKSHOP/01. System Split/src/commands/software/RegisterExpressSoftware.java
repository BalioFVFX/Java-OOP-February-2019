package commands.software;

import commands.base.BaseCommand;
import enums.SoftwareType;
import models.software.LightSoftware;
import models.software.Software;
import models.system.System;

public class RegisterExpressSoftware extends SoftwareRegister {
    public RegisterExpressSoftware(System system) {
        super(system);
    }

    @Override
    public void execute(String[] data) {
        String hardwareComponentName = data[0];
        Software expressSoftware = super.createSoftwareFrom(data, SoftwareType.EXPRESS_SOFTWARE);
        getSystem().addSoftwareOnHardware(hardwareComponentName, expressSoftware);
    }
}
