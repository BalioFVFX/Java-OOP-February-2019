package controller;

import appender.Appender;
import enums.ReportLevel;

import java.util.ArrayList;
import java.util.List;

public class MainController implements Controller {
    private List<Appender> appenders;

    public MainController() {
        this.appenders = new ArrayList<>();
    }

    public MainController(Appender appender) {
        this();
        this.addAppender(appender);
    }

    @Override
    public void addAppender(Appender appender) {
        this.appenders.add(appender);
    }


    @Override
    public void append(String dateTime, ReportLevel reportLevel, String text) {
        for (Appender appender : appenders) {
            appender.append(dateTime, reportLevel, text);
        }
    }

    @Override
    public String getLogsInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Appender appender : appenders) {
            stringBuilder.append(appender.toString()).append("\n");
        }
        stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), "");
        return stringBuilder.toString();
    }
}
