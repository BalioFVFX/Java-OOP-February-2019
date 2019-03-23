package appender.files;


import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class LogFile implements File {

    private StringBuilder stringBuilder;
    private String filePath;

    public LogFile(String filePath) {
        this.stringBuilder = new StringBuilder();
        this.filePath = filePath;
    }

    @Override
    public void write() {
        try {
            PrintWriter printWriter = new PrintWriter(this.filePath);
            printWriter.append(this.getText());
            printWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void append(String text){
        this.stringBuilder.append(text);
    }

    @Override
    public int getSize() {
        return this.calculateSize();
    }

    private int calculateSize(){
        int sum = 0;
        for (int i = 0; i < this.stringBuilder.length(); i++) {
            if(Character.isAlphabetic(this.stringBuilder.charAt(i))){
                sum += this.stringBuilder.charAt(i);
            }
        }
        return sum;
    }

    @Override
    public String getText() {
        return this.stringBuilder.toString();
    }
}
