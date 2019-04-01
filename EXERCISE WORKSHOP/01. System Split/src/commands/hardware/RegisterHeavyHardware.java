package commands.hardware;

import commands.base.BaseCommand;
import models.hardware.HeavyHardware;
import models.system.System;

public class RegisterHeavyHardware extends BaseCommand {
    public RegisterHeavyHardware(System system) {
        super(system);
    }

    @Override
    public void execute(String[] data) {
        String name = data[0];
        int capacity = Integer.parseInt(data[1]);
        int memory = Integer.parseInt(data[2]);

        super.getSystem().addHardwareComponent(new HeavyHardware(name, capacity, memory));
    }
}
