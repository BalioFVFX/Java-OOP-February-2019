package appender.files;

public interface File {
    void write();
    int getSize();
    String getText();
    void append(String text);
}
