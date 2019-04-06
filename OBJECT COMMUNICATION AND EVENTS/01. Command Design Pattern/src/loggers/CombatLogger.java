package loggers;

public class CombatLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("Log - " + message);
    }
}
