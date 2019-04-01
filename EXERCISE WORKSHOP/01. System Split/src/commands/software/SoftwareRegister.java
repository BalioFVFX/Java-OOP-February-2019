package commands.software;

import commands.base.BaseCommand;
import enums.SoftwareType;
import models.software.ExpressSoftware;
import models.software.LightSoftware;
import models.software.Software;
import models.system.System;

public abstract class SoftwareRegister extends BaseCommand {

    public SoftwareRegister(System system) {
        super(system);
    }


    protected Software createSoftwareFrom(String[] data, SoftwareType softwareType){
        String softwareName = data[1];
        int softwareCapacity = Integer.parseInt(data[2]);
        int softwareMemory = Integer.parseInt(data[3]);

        switch (softwareType){
            case EXPRESS_SOFTWARE:
                return new ExpressSoftware(softwareName, softwareCapacity, softwareMemory);
            case LIGHT_SOFTWARE:
                return new LightSoftware(softwareName, softwareCapacity, softwareMemory);
                default:return null;
        }
    }
}
