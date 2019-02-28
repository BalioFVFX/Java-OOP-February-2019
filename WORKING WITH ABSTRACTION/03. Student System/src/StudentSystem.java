import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentSystem {
    private StudentRepository repository;

    public StudentSystem() {
        this.repository = new StudentRepository();
    }

    public void ParseCommand(String[] args) {
        if (args[0].equals("Create")) {
            this.create(args);
        } else if (args[0].equals("Show")) {
            this.show(args);
        }
    }

    private void create(String[] args) {
        String name = args[1];
        int age = Integer.parseInt(args[2]);
        double grade = Double.parseDouble(args[3]);
        if (!this.repository.existsByName(name)) {
            Student student = new Student(name, age, grade);
            this.repository.save(student);
        }
    }

    private void show(String[] args) {
        String name = args[1];
        if (!this.repository.existsByName(name)) {
            return;
        }

        Student student = this.repository.findByName(name);

        System.out.println(student);
    }
}
