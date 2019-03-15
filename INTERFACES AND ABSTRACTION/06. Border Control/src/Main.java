import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input = bufferedReader.readLine();
        List<Identifiable> identifiables = new ArrayList<>();
        while (!input.equals("End")){
            String[] lines = input.split("\\s+");

            if(lines.length > 2){
                identifiables.add(new Citizen(lines[0], Integer.parseInt(lines[1]), lines[2]));
            }
            else{
                identifiables.add(new Robot(lines[1], lines[0]));
            }
            input = bufferedReader.readLine();
        }
        String fakeIdEnd = bufferedReader.readLine();
        identifiables.stream().filter(id -> id.getId().endsWith(fakeIdEnd)).forEach(identifiable -> {
            System.out.println(identifiable.getId());
        });
    }
}
