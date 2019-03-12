import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.InvalidParameterException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


//        String[] validStudentData = bufferedReader.readLine().split("\\s+");
//        Student validStudent = new Student(validStudentData[0], validStudentData[1], validStudentData[2]);
//
//        System.out.println(validStudent);

        String[] validWorkerData = bufferedReader.readLine().split("\\s+");

        Worker validWorker = new Worker(validWorkerData[0], validWorkerData[1],
                Double.parseDouble(validWorkerData[2]), Double.parseDouble(validWorkerData[3]));
        System.out.println(validWorker.toString());
    }

}
