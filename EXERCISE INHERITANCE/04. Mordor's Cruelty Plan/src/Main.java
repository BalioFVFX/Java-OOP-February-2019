import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Gandalf gandalf = new Gandalf();
        String[] foods = bufferedReader.readLine().split("\\s+");

        for (String food: foods) {
            gandalf.eatFood(food);
        }

        System.out.println(gandalf);
    }
}
