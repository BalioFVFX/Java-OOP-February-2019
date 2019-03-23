package controller;

import appender.Appender;
import enums.ReportLevel;

public interface Controller {
    void addAppender(Appender appender);
    void append(String dateTime, ReportLevel reportLevel, String text);
    String getLogsInfo();
}
