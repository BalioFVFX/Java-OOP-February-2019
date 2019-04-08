import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        EntityObserver observer = new EntityObserver();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input = bufferedReader.readLine();

        observer.addObservable(new King(input));

        List<Entity> royalGuards = Arrays.stream(bufferedReader.readLine().split("\\s+"))
                .map(RoyalGuard::new)
                .collect(Collectors.toList());

        List<Entity> footmanList = Arrays.stream(bufferedReader.readLine().split("\\s+"))
                .map(Footman::new)
                .collect(Collectors.toList());

        observer.addObservables(royalGuards);
        observer.addObservables(footmanList);

        input = bufferedReader.readLine();

        while (!input.equals("End")){
            if(input.equals("Attack King")){
                observer.fireEvents();
            }
            else{
                observer.removeObservable(input.split("\\s+")[1]);
            }
            input = bufferedReader.readLine();
        }

    }
}
