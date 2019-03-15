import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] lines = bufferedReader.readLine().split(" \\| ");

        String username = lines[0];
        String characterType = lines[1];
        String specialPoints = lines[2];
        int level = Integer.parseInt(lines[3]);

        Character character = null;
        if(characterType.equals("Archangel")){
            character = new Archangel(username, level, Integer.parseInt(specialPoints));
        }
        else{
            character = new Demon(username, level, Double.parseDouble(specialPoints));
        }

        System.out.println(character);
    }
}
