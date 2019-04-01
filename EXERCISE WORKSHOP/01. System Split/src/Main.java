import engine.Engine;
import models.hardware.HeavyHardware;
import models.hardware.PowerHardware;
import models.system.System;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System system = new System();
        Engine engine = new Engine(system);

        engine.run();
    }
}
