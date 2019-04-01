package commands.hardware;

import commands.base.BaseCommand;
import models.hardware.PowerHardware;
import models.system.System;

public class RegisterPowerHardwareCommand extends BaseCommand {

    public RegisterPowerHardwareCommand(System system) {
        super(system);
    }

    @Override
    public void execute(String[] data) {
        String name = data[0];
        int capacity = Integer.parseInt(data[1]);
        int memory = Integer.parseInt(data[2]);

        super.getSystem().addHardwareComponent(new PowerHardware(name, capacity, memory));
    }
}
