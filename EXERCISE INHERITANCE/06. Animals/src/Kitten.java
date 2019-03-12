import java.security.InvalidParameterException;

public class Kitten extends Cat {
    public Kitten(String name, int age, String gender) {
        super(name, age, gender);
        this.setGender(gender);
    }

    protected void setGender(String gender){
        if(!gender.toLowerCase().equals("female")){
            throw new InvalidParameterException("Invalid input!");
        }
        super.setGender(gender);
    }

    @Override
    public String produceSound() {
        return "Miau";
    }
}
