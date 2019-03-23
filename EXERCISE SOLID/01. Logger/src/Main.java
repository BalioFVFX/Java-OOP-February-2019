import controller.Controller;
import enums.ReportLevel;
import input.InputParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfAppenders = Integer.parseInt(bufferedReader.readLine());
        InputParser inputParser = new InputParser();

        Controller mainController = inputParser.createController(bufferedReader, numberOfAppenders);

        String input = bufferedReader.readLine();

        while (!input.equals("END")){
            String[] lines = input.split("\\|");
            ReportLevel reportLevel = ReportLevel.valueOf(lines[0]);
            String dateTime = lines[1];
            String message = lines[2];
            mainController.append(dateTime, reportLevel, message);

            input = bufferedReader.readLine();
        }
        System.out.println(mainController.getLogsInfo());
    }
}
