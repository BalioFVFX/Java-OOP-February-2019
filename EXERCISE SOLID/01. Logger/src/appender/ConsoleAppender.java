package appender;

import enums.ReportLevel;
import layout.interfaces.Layout;

public class ConsoleAppender extends BaseAppender {

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    public ConsoleAppender(Layout layout, ReportLevel reportLevel) {
        super(layout, reportLevel);
    }

    @Override
    public boolean append(String dateTime, ReportLevel reportLevel, String text) {
        if(!isAppendable(reportLevel)){
            return false;
        }
        System.out.println(this.getLayout().format(dateTime, reportLevel, text));
        super.incrementAppends();
        return true;
    }
}
