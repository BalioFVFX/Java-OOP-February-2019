package appender.files;

import appender.BaseAppender;
import enums.ReportLevel;
import layout.interfaces.Layout;


public class FileAppender extends BaseAppender {

    private File logFile;

    public FileAppender(Layout layout) {
        super(layout);
    }

    public FileAppender(Layout layout, ReportLevel reportLevel) {
        super(layout, reportLevel);
    }


    public void setFile(File file){
        this.logFile = file;
    }

    @Override
    public boolean append(String dateTime, ReportLevel reportLevel, String text) {
        if(this.logFile == null || !isAppendable(reportLevel)){
            return false;
        }
        String output = this.getLayout().format(dateTime, reportLevel, text);
        this.logFile.append(output);
        this.logFile.write();
        super.incrementAppends();
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + " File size: " + this.logFile.getSize();
    }
}
