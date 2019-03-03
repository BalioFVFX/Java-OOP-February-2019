import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.InvalidParameterException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfPeople = Integer.parseInt(bufferedReader.readLine());
        Team team = new Team("SoftUni Team");
        for (int i = 0; i < numberOfPeople; i++) {
            String[] input = bufferedReader.readLine().split("\\s+");
            try{
                team.addPlayer(new Person(input[0], input[1], Integer.parseInt(input[2]), Double.parseDouble(input[3])));
            }
            catch (InvalidParameterException ex){
                System.out.println(ex.getMessage());
            }
        }

        System.out.printf("First team have %d players%n", team.getFirstTeam().size());
        System.out.printf("Reserve team have %d players%n", team.getReserveTeam().size());
    }
}
