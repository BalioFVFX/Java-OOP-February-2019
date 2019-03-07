import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.InvalidParameterException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        double length = Double.parseDouble(bufferedReader.readLine());
        double width = Double.parseDouble(bufferedReader.readLine());
        double height = Double.parseDouble(bufferedReader.readLine());

        try{
            Box box = new Box(length, width, height);
            System.out.println(box.toString());
        }catch (InvalidParameterException ex){
            System.out.println(ex.getMessage());
        }

    }
}
