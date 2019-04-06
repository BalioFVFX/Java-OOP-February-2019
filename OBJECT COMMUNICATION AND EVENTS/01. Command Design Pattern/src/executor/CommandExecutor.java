package executor;

import commands.Command;



public class CommandExecutor implements Executor{


    public CommandExecutor() {

    }

    @Override
    public void execute(Command command) {
        command.execute();
    }
}
