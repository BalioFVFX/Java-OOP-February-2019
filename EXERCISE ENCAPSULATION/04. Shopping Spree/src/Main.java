import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.LinkedHashMap;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] peopleInput = bufferedReader.readLine().split(";");
        String[] productsInput = bufferedReader.readLine().split(";");

        HashMap<String, Person> people = new LinkedHashMap<>();
        HashMap<String, Product> products = new LinkedHashMap<>();
        for (int i = 0; i < peopleInput.length; i++) {
            try {
                String[] currentData = getInputAsArray(peopleInput[i]);
                Person person = new Person(currentData[0], Double.parseDouble(currentData[1]));
                people.put(person.getName(), person);
            } catch (InvalidParameterException ex) {
                System.out.println(ex.getMessage());
                return;
            }
        }

        for (int i = 0; i < productsInput.length; i++) {
            try {
                String[] currentData = getInputAsArray(productsInput[i]);
                Product product = new Product(currentData[0], Double.parseDouble(currentData[1]));
                products.put(product.getName(), product);
            } catch (InvalidParameterException ex) {
                System.out.println(ex.getMessage());
                return;
            }
        }


        String input = bufferedReader.readLine();
        while (!input.equals("END")) {
            String[] lines = input.split("\\s+");
            people.get(lines[0]).buyProduct(products.get(lines[1]));

            input = bufferedReader.readLine();
        }

        people.values().forEach(person -> {
            System.out.println(person.toString());
        });
    }

    private static String[] getInputAsArray(String input) {
        String name = input.split("=")[0];
        String moneyStr = input.split("=")[1];

        return new String[]{name, moneyStr};
    }
}
