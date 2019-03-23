package appender;

import enums.ReportLevel;
import layout.interfaces.Layout;

public abstract class BaseAppender implements Appender {

    private Layout layout;
    private ReportLevel reportLevel;
    private int appendCount;

    public BaseAppender(Layout layout) {
        this.layout = layout;
        this.reportLevel = ReportLevel.INFO;
    }

    public BaseAppender(Layout layout, ReportLevel reportLevel) {
        this(layout);
        this.reportLevel = reportLevel;
    }


    @Override
    public abstract boolean append(String dateTime, ReportLevel reportLevel, String text);

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    public Layout getLayout() {
        return layout;
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
    }

    protected boolean isAppendable(ReportLevel reportLevel){
        return this.reportLevel.ordinal() <= reportLevel.ordinal();
    }

    @Override
    public ReportLevel getReportLevel(){
        return this.reportLevel;
    }

    @Override
    public int getAppendCount() {
        return this.appendCount;
    }

    protected void incrementAppends(){
        this.appendCount++;
    }

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages append: %s",
                this.getClass().getSimpleName(),
                this.getLayout().getClass().getSimpleName(),
                this.getReportLevel().name(),
                this.getAppendCount());
    }
}
