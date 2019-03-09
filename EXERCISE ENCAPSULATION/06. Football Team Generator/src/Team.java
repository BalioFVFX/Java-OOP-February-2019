import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team() {
        this.players = new ArrayList<>();
    }

    public Team(String name) {
        this();
        this.setName(name);
    }

    private void setName(String name) {
        if(name == null || name.trim().equals("")){
            throw new InvalidParameterException("A name should not be empty. ");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public void removePlayer(String name){
        Player playerToRemove = this.players.stream().filter(p -> p.getName().equals(name)).findFirst().orElseThrow(InvalidParameterException::new);
        this.players.remove(playerToRemove);
    }

    public double getRating(){
        return this.players.stream().mapToDouble(Player::overallSkillLevel).sum();
    }
}
