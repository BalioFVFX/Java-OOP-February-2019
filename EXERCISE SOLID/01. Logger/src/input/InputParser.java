package input;

import appender.Appender;
import appender.ConsoleAppender;
import appender.files.FileAppender;
import appender.files.LogFile;
import controller.Controller;
import controller.MainController;
import enums.ReportLevel;
import layout.SimpleLayout;
import layout.XmlLayout;
import layout.interfaces.Layout;

import java.io.BufferedReader;
import java.io.IOException;

public class InputParser {
    public Controller createController(BufferedReader bufferedReader, int numberOfAppenders) throws IOException {
        Controller controller = new MainController();
        for (int i = 0; i < numberOfAppenders; i++) {
            String[] lines = bufferedReader.readLine().split("\\s+");
            String appenderType = lines[0];
            String layoutType = lines[1];

            Layout layout = createLayout(layoutType);
            Appender appender = createAppender(appenderType, layout);
            if (lines.length > 2) {
                ReportLevel reportLevel = ReportLevel.valueOf(lines[2]);
                appender.setReportLevel(reportLevel);
            }
            controller.addAppender(appender);
        }
        return controller;
    }

    private Layout createLayout(String layoutType) {
        switch (layoutType) {
            case "SimpleLayout":
                return new SimpleLayout();
            case "XmlLayout":
                return new XmlLayout();
            default:
                return null;
        }
    }

    private Appender createAppender(String appenderType, Layout layout) {
        switch (appenderType) {
            case "ConsoleAppender":
                return new ConsoleAppender(layout);
            case "FileAppender":
                Appender fileAppender = new FileAppender(layout);
                ((FileAppender) fileAppender).setFile(new LogFile("C:\\Users\\Erik\\Desktop\\01. Logger\\output.txt"));
                return fileAppender;
            default:
                return null;

        }
    }
}
