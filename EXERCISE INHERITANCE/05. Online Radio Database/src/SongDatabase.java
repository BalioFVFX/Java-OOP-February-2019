import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SongDatabase {
    private List<Song> songs;

    public SongDatabase() {
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song){
        this.songs.add(song);
    }

    public String getTotalLengthOfSongs(){
        int hours = 0;
        int minutes = 0;
        int seconds =0;

        for (Song song: songs) {
            int[] songLengthTokens = Arrays.stream(song.getLength().split(":")).mapToInt(Integer::parseInt).toArray();
            int currentMinutes = songLengthTokens[0];
            int currentSeconds = songLengthTokens[1];

            minutes += currentMinutes;
            seconds += currentSeconds;

            if(seconds >= 60){
                seconds -= 60;
                minutes++;
            }

            if(minutes >= 60){
                minutes -= 60;
                hours++;
            }
        }
        return String.format("Playlist length: %dh %dm %ds",
                hours, minutes, seconds);
    }

    @Override
    public String toString() {
        return String.format("Songs added: %d%nPlaylist length: %s",
                this.songs.size(),
                this.getTotalLengthOfSongs());
    }
}
