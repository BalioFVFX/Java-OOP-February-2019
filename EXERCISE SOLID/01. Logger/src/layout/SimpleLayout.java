package layout;

import enums.ReportLevel;
import layout.interfaces.Layout;


public class SimpleLayout implements Layout {
    @Override
    public String format(String dateTime, ReportLevel reportLevel, String text) {
        return String.format("%s - %s - %s",
                dateTime,
                reportLevel.name(),
                text);

    }
}
