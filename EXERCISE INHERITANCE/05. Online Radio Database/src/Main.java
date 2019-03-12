import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfSongs = Integer.parseInt(bufferedReader.readLine());
        SongDatabase songDatabase = new SongDatabase();
        for (int i = 0; i < numberOfSongs; i++) {
            try{
                String[] lines = bufferedReader.readLine().split(";");
                songDatabase.addSong(new Song(lines[0], lines[1], lines[2]));
            }
            catch (InvalidSongException ex){
                System.out.println(ex.getMessage());
            }
        }
        System.out.println(songDatabase);
    }
}
