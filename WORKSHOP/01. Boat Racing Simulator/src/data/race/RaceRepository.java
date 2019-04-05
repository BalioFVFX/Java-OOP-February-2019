package data.race;

import exception.*;
import model.boat.Boat;
import model.race.Race;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RaceRepository {
    private Race race;

    public RaceRepository() {
        this.race = null;
    }

    public void openRace(Race race) throws RaceAlreadyExistsException {
        if(this.race != null){
            throw new RaceAlreadyExistsException("The current race has already been set.");
        }
        this.race = race;
    }

    public void signUpBoat(Boat boat) throws NoSetRaceException, DuplicateModelException, ArgumentException {
        if(this.race == null){
            throw new NoSetRaceException("There is currently no race set.");
        }
        this.race.addBoat(boat);
    }

    public String startRace() throws NoSetRaceException, InsufficientContestantsException {
        if(this.race == null){
            throw new NoSetRaceException("There is currently no race set.");
        }

        if(!this.race.hasEnoughBoats()){
            throw new InsufficientContestantsException("Not enough contestants for the race.");
        }

        StringBuilder output = new StringBuilder();
        List<Boat> boats = this.race.getBoats()
                .stream()
                .sorted((b1, b2) -> Double.compare(b2.getSpeed(this.race.getWeather()), b1.getSpeed(this.race.getWeather())))
                .limit(3)
                .collect(Collectors.toList());



        output.append("First place: ")
                .append(boats.get(0).getClass().getSimpleName())
                .append(" Model: ")
                .append(boats.get(0).getModel())
                .append(" ")
                .append("Time: ").append(String.format("%s", getBoatTime(boats.get(0), race)))
                .append("\n");

        output.append("Second place: ")
                .append(boats.get(1).getClass().getSimpleName())
                .append(" Model: ")
                .append(boats.get(1).getModel())
                .append(" ")
                .append("Time: ").append(String.format("%s", getBoatTime(boats.get(1), race)))
                .append("\n");

        output.append("Third place: ")
                .append(boats.get(2).getClass().getSimpleName())
                .append(" Model: ")
                .append(boats.get(2).getModel())
                .append(" ")
                .append("Time: ").append(String.format("%s", getBoatTime(boats.get(2), race)));

        this.race = null;
        return output.toString();
    }

    public Set<Boat> getParticipants() throws NoSetRaceException {
        if(this.race == null){
            throw new NoSetRaceException("There is currently no race set.");
        }

        return this.race.getParticipantsBoats();
    }

    private static String getBoatTime(Boat boat, Race race){
        double speed = boat.getSpeed(race.getWeather());
        speed = race.getDistance() / speed;
        if(speed <= 0){
            return "Did not finish!";
        }
        return String.format("%.2f sec", speed);
    }
}
