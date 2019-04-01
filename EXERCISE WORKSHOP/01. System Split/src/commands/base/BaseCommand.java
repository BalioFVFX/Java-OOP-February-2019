package commands.base;

import models.system.System;

public abstract class BaseCommand implements Command{
    private System system;

    public BaseCommand(System system) {
        this.setSystem(system);
    }

    public System getSystem() {
        return system;
    }

    public void setSystem(System system) {
        this.system = system;
    }
}
