package logger;


public interface Logger {
    void logError(String dateTime, String text);
    void logInfo(String dateTime, String text);
}
