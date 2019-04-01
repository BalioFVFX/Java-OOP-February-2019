package commands.executor;

import commands.base.Command;

public interface Executable {
    void execute(Command command, String[] data);
}
