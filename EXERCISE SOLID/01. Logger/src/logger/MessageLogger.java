package logger;

import appender.Appender;
import enums.ReportLevel;

public class MessageLogger implements Logger {

    private final Appender appender;


    public MessageLogger(Appender appender) {
        this.appender = appender;
    }


    private void logAll(String dateTime, ReportLevel reportLevel, String text){
        this.appender.append(dateTime, reportLevel, text);
    }

    @Override
    public void logError(String dateTime, String text) {
        this.logAll(dateTime, ReportLevel.ERROR, text);
    }

    @Override
    public void logInfo(String dateTime, String text) {
        this.logAll(dateTime, ReportLevel.INFO, text);
    }

}
