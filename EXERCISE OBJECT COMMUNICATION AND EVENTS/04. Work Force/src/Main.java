import employees.PartTimeEmployee;
import employees.StandardEmployee;
import job.Job;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input = bufferedReader.readLine();
        Economy economy = new Economy();

        while (!input.equals("End")){

            String[] data = input.split("\\s+");

            if(input.contains("Job")){
                economy.addJob(new Job(data[1], Integer.parseInt(data[2]), economy.getEmployeeByName(data[3])));
            }
            else if(input.contains("StandartEmployee")){
                economy.addEmployee(new StandardEmployee(data[1]));
            }
            else if(input.contains("PartTimeEmployee")){
                economy.addEmployee(new PartTimeEmployee(data[1]));
            }
            else if(input.contains("Pass Week")){
                economy.passWeek();
            }
            else if(input.contains("Status")){
                economy.getStatus();
            }
            input = bufferedReader.readLine();
        }
    }
}
