package engine;

import commands.analyze.Analyst;
import commands.base.Command;
import commands.executor.CommandExecutor;
import commands.hardware.RegisterHeavyHardware;
import commands.hardware.RegisterPowerHardwareCommand;
import commands.release.ReleaseSoftwareComponent;
import commands.software.RegisterExpressSoftware;
import commands.software.RegisterLightSoftware;
import commands.software.dump.DumpCommand;
import commands.software.dump.DumpDestroyCommand;
import commands.software.dump.DumpRestoreCommand;
import models.system.System;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class Engine {
    private System system;
    private LinkedHashMap<String, Command> commands;
    private CommandExecutor commandExecutor = new CommandExecutor();

    public Engine(System system) {
        this.system = system;
        this.commands = new LinkedHashMap<>();
        this.initCommands();
    }

    public void run() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(java.lang.System.in));

        String input = bufferedReader.readLine();

        while (!input.equals("System Split")) {
            String[] lines = input.split("\\(|\\)");
            String[] data = null;
            String commandTXT = lines[0];

            try {
                data = Arrays.stream(lines[1].split(", ")).filter(txt -> !txt.equals(" ")).toArray(String[]::new);
            } catch (ArrayIndexOutOfBoundsException ex) {
                String analysis =  Analyst.analyze(this.system, commandTXT);

                java.lang.System.out.println(analysis);
                input = bufferedReader.readLine();
                continue;
            }


            Command command = this.commands.get(commandTXT);

            this.commandExecutor.execute(command, data);

            input = bufferedReader.readLine();
        }

        java.lang.System.out.println(this.system.split());

    }

    private void initCommands() {
        this.commands.put("RegisterPowerHardware", new RegisterPowerHardwareCommand(this.system));
        this.commands.put("RegisterHeavyHardware", new RegisterHeavyHardware(this.system));
        this.commands.put("RegisterLightSoftware", new RegisterLightSoftware(this.system));
        this.commands.put("RegisterExpressSoftware", new RegisterExpressSoftware(this.system));
        this.commands.put("ReleaseSoftwareComponent", new ReleaseSoftwareComponent(this.system));
        this.commands.put("Dump", new DumpCommand(this.system));
        this.commands.put("Restore", new DumpRestoreCommand(this.system));
        this.commands.put("Destroy", new DumpDestroyCommand(this.system));
    }
}
