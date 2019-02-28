import java.util.HashMap;
import java.util.Map;

public class StudentRepository {
    private Map<String, Student> data;

    public StudentRepository() {
        this.data = new HashMap<>();
    }

    public boolean existsByName(String name) {
        return this.data.containsKey(name);
    }

    public void save(Student student) {
        this.data.put(student.getName(), student);
    }

    public Student findByName(String name) {
        return this.data.get(name);
    }
}
