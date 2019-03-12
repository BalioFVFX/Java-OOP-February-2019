import java.security.InvalidParameterException;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    private void setName(String name) {
        if(name == null || name.trim().equals("")){
            throw new InvalidParameterException("Invalid input!");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if(age <= 0){
            throw new InvalidParameterException("Invalid input!");
        }
        this.age = age;
    }

    protected void setGender(String gender) {
        if(gender == null || gender.trim().equals("")){
            throw new InvalidParameterException("Invalid input!");
        }
        this.gender = gender;
    }

    protected String produceSound(){
        return "Not implemented!";
    }

    @Override
    public String toString() {
        return String.format("%s%n%s %s %s%n%s",
                this.getClass().getSimpleName(),
                this.name, this.age, this.gender,
                this.produceSound());
    }
}
