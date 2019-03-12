import java.security.InvalidParameterException;

public class Tomcat extends Cat {
    public Tomcat(String name, int age, String gender) {
        super(name, age, gender);
        this.setGender(gender);
    }

    protected void setGender(String gender){
        if(!gender.toLowerCase().equals("male")){
            throw new InvalidParameterException("Invalid input!");
        }
        super.setGender(gender);
    }

    @Override
    public String produceSound() {
        return "Give me one million b***h";
    }
}
