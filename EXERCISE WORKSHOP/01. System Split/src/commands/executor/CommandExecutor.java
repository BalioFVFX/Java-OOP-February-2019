package commands.executor;

import commands.base.Command;

import java.util.LinkedHashMap;

public class CommandExecutor implements Executable {

    private LinkedHashMap<String, Command> commands;

    public CommandExecutor() {
        this.commands = new LinkedHashMap<>();
    }

    @Override
    public void execute(Command command, String[] data) {
        command.execute(data);
    }
}
