import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.InvalidParameterException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = bufferedReader.readLine();

            if (input.equals("Beast!")) {
                return;
            }

            String[] lines = bufferedReader.readLine().split("\\s+");

            String name = lines[0];
            int age = Integer.parseInt(lines[1]);
            String gender = lines[2];

            try {
                switch (input) {
                    case "Dog":
                        System.out.println(new Dog(name, age, gender));
                        break;
                    case "Cat":
                        System.out.println(new Cat(name, age, gender));
                        break;
                    case "Frog":
                        System.out.println(new Frog(name, age, gender));
                        break;
                    case "Kitten":
                        System.out.println(new Kitten(name, age, gender));
                        break;
                    case "Tomcat":
                        System.out.println(new Tomcat(name, age, gender));
                        break;
                    case "Animal":
                        System.out.println(new Animal(name, age, gender));
                        break;
                    default:
                        throw new InvalidParameterException("Invalid input!");
                }
            } catch (InvalidParameterException ex) {
                System.out.println(ex.getMessage());
            }


        }
    }
}
