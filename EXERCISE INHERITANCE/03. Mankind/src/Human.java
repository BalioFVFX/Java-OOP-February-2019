import java.security.InvalidParameterException;

public class Human {
    private String firstName;
    protected String lastName;

    public Human() {
    }

    public Human(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }


    protected void setFirstName(String firstName) {
        if(firstName.charAt(0) == firstName.toLowerCase().charAt(0)){
            throw new InvalidParameterException("Expected upper case letter!Argument: firstName");
        }
        if(firstName.length() < 4){
            throw new InvalidParameterException("Expected length at least 4 symbols!Argument: firstName");
        }
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        if(lastName.charAt(0) == lastName.toLowerCase().charAt(0)){
            throw new InvalidParameterException("Expected upper case letter!Argument: lastName");
        }
        if(lastName.length() < 3){
            throw new InvalidParameterException("Expected length at least 3 symbols!Argument: lastName");
        }
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("First Name: %s%nLast Name: %s", this.firstName, this.lastName);
    }
}
