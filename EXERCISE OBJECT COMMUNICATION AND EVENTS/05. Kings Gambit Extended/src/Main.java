import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input = bufferedReader.readLine();

        King king = new King(input);

        List<Soldier> royalGuards = Arrays.stream(bufferedReader.readLine().split("\\s+"))
                .map(RoyalGuard::new)
                .collect(Collectors.toList());

        List<Soldier> footmanList = Arrays.stream(bufferedReader.readLine().split("\\s+"))
                .map(Footman::new)
                .collect(Collectors.toList());

        king.addObservableSoldiers(royalGuards);
        king.addObservableSoldiers(footmanList);

        input = bufferedReader.readLine();

        while (!input.equals("End")){
            if(input.equals("Attack King")){
                king.fireEvents();
            }
            else{
                king.killObservable(input.split("\\s+")[1]);
            }
            input = bufferedReader.readLine();
        }

    }
}
