import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.InvalidParameterException;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, Team> teams = new LinkedHashMap<>();
        String input = bufferedReader.readLine();

        while (!input.equals("END")) {
            String[] lines = input.split(";");

            if (lines[0].equals("Team")) {
                try {
                    Team team = new Team(lines[1]);
                    teams.put(lines[1], new Team(lines[1]));
                } catch (InvalidParameterException ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (lines[0].equals("Add")) {
                Team team = teams.get(lines[1]);
                if (team == null) {
                    System.out.printf("Team %s does not exist.%n", lines[1]);
                } else {
                    try {
                        Player player = new Player(lines[2],
                                Integer.parseInt(lines[3]),
                                Integer.parseInt(lines[4]),
                                Integer.parseInt(lines[5]),
                                Integer.parseInt(lines[6]),
                                Integer.parseInt(lines[7]));
                        team.addPlayer(player);
                    } catch (InvalidParameterException ex) {
                        System.out.println(ex.getMessage());
                    }

                }

            } else if (lines[0].equals("Remove")) {
                Team team = teams.get(lines[1]);
                if (team == null) {
                    System.out.printf("Team %s does not exist.%n", lines[1]);
                } else {
                    try {
                        team.removePlayer(lines[2]);
                    } catch (InvalidParameterException ex) {
                        System.out.printf("Player %s is not in %s team. %n", lines[2], lines[1]);
                    }
                }

            } else if (lines[0].equals("Rating")) {
                Team team = teams.get(lines[1]);
                if (team == null) {
                    System.out.printf("Team %s does not exist.%n", lines[1]);
                } else {
                    System.out.printf("%s - %.0f%n", team.getName(), team.getRating());
                }

            }

            input = bufferedReader.readLine();
        }

    }
}
