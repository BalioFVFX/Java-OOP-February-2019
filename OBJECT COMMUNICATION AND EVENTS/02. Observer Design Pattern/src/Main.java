import commands.*;
import executor.CommandExecutor;
import executor.Executor;
import loggers.CombatLogger;
import loggers.Logger;
import models.Attacker;
import models.Dragon;
import models.Target;
import models.Warrior;
import observers.ObservableTarget;


public class Main {
    public static void main(String[] args) {
        Logger combatLog = new CombatLogger();

        Attacker warrior = new Warrior("Warrior", 10, combatLog);
        ObservableTarget dragon = new Dragon("Dragon", 5, 25, combatLog);

        Executor executor = new CommandExecutor();

        Command targetCommand = new TargetCommand(warrior, dragon);
        Command attackCommand = new AttackCommand(warrior);
        Command registerObserver = new RegisterObserverCommand(dragon, warrior);
        Command notifyObserver = new NotifyCommand(dragon);



        executor.execute(targetCommand);
        executor.execute(attackCommand);
        executor.execute(registerObserver);
        executor.execute(notifyObserver);
    }
}
