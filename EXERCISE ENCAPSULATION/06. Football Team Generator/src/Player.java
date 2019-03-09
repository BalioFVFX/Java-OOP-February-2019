import java.security.InvalidParameterException;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if(name == null || name.trim().equals("")){
            throw new InvalidParameterException("A name should not be empty. ");
        }
        this.name = name;
    }


    private void setEndurance(int endurance) {
        if(!isValidStat(endurance)){
            throw new InvalidParameterException("Endurance should be between 0 and 100. ");
        }
        this.endurance = endurance;
    }


    private void setSprint(int sprint) {
        if(!isValidStat(sprint)){
            throw new InvalidParameterException("Sprint should be between 0 and 100. ");
        }
        this.sprint = sprint;
    }


    private void setDribble(int dribble) {
        if(!isValidStat(dribble)){
            throw new InvalidParameterException("Dribble should be between 0 and 100. ");
        }
        this.dribble = dribble;
    }


    private void setPassing(int passing) {
        if(!isValidStat(passing)){
            throw new InvalidParameterException("Passing should be between 0 and 100. ");
        }
        this.passing = passing;
    }


    private void setShooting(int shooting) {
        if(!isValidStat(endurance)){
            throw new InvalidParameterException("Shooting should be between 0 and 100. ");
        }
        this.shooting = shooting;
    }

    private static boolean isValidStat(int skillLevel){
        if(skillLevel < 0 || skillLevel > 100){
            return false;
        }
        return true;
    }

    public double overallSkillLevel(){
        return ((double)this.endurance + this.sprint + this.dribble + this.passing + this.shooting) / 5;
    }
}
