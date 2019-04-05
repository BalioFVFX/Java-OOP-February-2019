package model.race;

import com.sun.jdi.connect.Connector;
import exception.ArgumentException;
import exception.DuplicateModelException;
import model.boat.Boat;
import model.boat.motorboat.Motorboat;

import java.util.HashSet;
import java.util.Set;

public class Race {
    private int distance;
    private Weather weather;
    private Set<Boat> boats;
    private boolean allowedMotorboats;

    public Race(int distance, int windSpeed, int oceanCurrentSpeed, boolean allowedMotorboats) throws ArgumentException {
        this.setDistance(distance);
        this.setWeather(new Weather(windSpeed, oceanCurrentSpeed));
        this.setAllowedMotorboats(allowedMotorboats);
        this.boats = new HashSet<>();
    }

    public boolean hasEnoughBoats(){
        return this.boats.size() >= 3;
    }

    public void addBoat(Boat boat) throws DuplicateModelException, ArgumentException {

        if(!this.allowedMotorboats && boat instanceof Motorboat){
            throw new ArgumentException("The specified boat does not meet the race constraints.");
        }

        boolean isUnique = this.boats.add(boat);

        if(!isUnique){
            throw new DuplicateModelException("The specified boat does not meet the race constraints.");
        }
    }

    public Set<Boat> getParticipantsBoats(){
        return new HashSet<>(boats);
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) throws ArgumentException {
        if(distance <= 0){
            throw new ArgumentException("Distance must be a positive integer.");
        }
        this.distance = distance;
    }

    public Weather getWeather(){
        return this.weather;
    }

    public void setWeather(Weather weather){
        this.weather = weather;
    }

    public Set<Boat> getBoats() {
        return boats;
    }

    public void setBoats(Set<Boat> boats) {
        this.boats = boats;
    }

    public boolean isAllowedMotorboats() {
        return allowedMotorboats;
    }

    public void setAllowedMotorboats(boolean allowedMotorboats) {
        this.allowedMotorboats = allowedMotorboats;
    }
}
