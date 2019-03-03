import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private List<Person> firstTeam;
    private List<Person> reserveTeam;
    private String name;

    public Team(){
        this.firstTeam = new ArrayList<>();
        this.reserveTeam = new ArrayList<>();
    }

    public Team(String name) {
        this();
        this.setName(name);
    }

    public void addPlayer(Person person){
        if(person.getAge() < 40){
            this.firstTeam.add(person);
        }
        else{
            this.reserveTeam.add(person);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getFirstTeam(){
        return Collections.unmodifiableList(this.firstTeam);
    }

    public List<Person> getReserveTeam(){
        return Collections.unmodifiableList(this.reserveTeam);
    }

}
