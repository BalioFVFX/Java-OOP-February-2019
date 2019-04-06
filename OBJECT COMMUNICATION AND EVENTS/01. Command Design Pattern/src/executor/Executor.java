package executor;

import commands.Command;

public interface Executor {
    void execute(Command command);
}
