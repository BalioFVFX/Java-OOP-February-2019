package p01_FileStream;

public class Main {
    public static void main(String[] args) {
        File file = new File();
        Music music = new Music();

        Progress progressFile = new Progress(file);
        Progress musicFile = new Progress(music);

        System.out.println(progressFile.getCurrentPercent());
        System.out.println(musicFile.getCurrentPercent());
    }
}

