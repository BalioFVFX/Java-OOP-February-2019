import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.InvalidParameterException;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] lines = bufferedReader.readLine().split("\\s+");

        Pizza pizza = null;
        try {
            pizza = new Pizza(lines[1], Integer.parseInt(lines[2]));
        } catch (InvalidParameterException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        lines = bufferedReader.readLine().split("\\s+");

        try {
            Dough dough = new Dough(lines[1], lines[2], Double.parseDouble(lines[3]));
            pizza.setDough(dough);
        } catch (InvalidParameterException ex) {
            System.out.println(ex.getMessage());
            return;
        }


        while (true) {
            lines = bufferedReader.readLine().split("\\s+");
            if (lines[0].equals("END")) {
                break;
            }
            try {
                pizza.addTopping(new Topping(lines[1], Double.parseDouble(lines[2])));
            } catch (InvalidParameterException ex) {
                System.out.println(ex.getMessage());
                return;
            }
        }


        System.out.println(pizza.toString());
    }
}
