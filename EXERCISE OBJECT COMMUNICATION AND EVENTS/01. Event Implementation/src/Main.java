import javax.naming.Name;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input = bufferedReader.readLine();

        Dispatcher dispatcher = new Dispatcher();
        Handler handler = new Handler();


        dispatcher.addNameChangeListener(handler);
        while (!input.equals("End")){
            String name = input;
            NameChange event = new NameChange(dispatcher, name);
            dispatcher.fireNameChangeEvent(event);

            input = bufferedReader.readLine();
        }
    }
}
