package layout;

import enums.ReportLevel;
import layout.interfaces.Layout;

public class XmlLayout implements Layout {
    @Override
    public String format(String dateTime, ReportLevel reportLevel, String text) {
        return String.format("<log>%n  <date>%s</date>%n  <level>%s</level>%n  <message>%s</message>%n</log>%n",
                dateTime,
                reportLevel.name(),
                text);
    }
}
