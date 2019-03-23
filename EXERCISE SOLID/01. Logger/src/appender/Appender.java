package appender;

import enums.ReportLevel;
import layout.interfaces.Layout;


public interface Appender {
    boolean append(String dateTime, ReportLevel reportLevel, String text);
    void setReportLevel(ReportLevel reportLevel);
    int getAppendCount();
    ReportLevel getReportLevel();
    Layout getLayout();
}
