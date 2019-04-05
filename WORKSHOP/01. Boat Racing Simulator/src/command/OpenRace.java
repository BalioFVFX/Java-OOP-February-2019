package command;

import data.race.RaceRepository;
import exception.ArgumentException;
import exception.DuplicateModelException;
import exception.NonExistantModelException;
import exception.RaceAlreadyExistsException;
import model.race.Race;

public class OpenRace extends BaseCommand {

    private RaceRepository raceRepository;


    public OpenRace(String[] data, RaceRepository raceRepository) {
        super(data);
        this.raceRepository = raceRepository;
    }

    @Override
    public String execute() throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, ArgumentException {
        int distance = Integer.parseInt(getData()[1]);
        int windSpeed = Integer.parseInt(getData()[2]);
        int oceanCurrentSpeed = Integer.parseInt(getData()[3]);
        boolean allowedMotorBoats = getData()[4].equals("true");

        Race race = new Race(distance, windSpeed, oceanCurrentSpeed, allowedMotorBoats);
        this.raceRepository.openRace(race);

        return String.format("A new race with distance %d meters, wind speed %d m/s and ocean current speed %d m/s has been set.",
                distance,
                windSpeed,
                oceanCurrentSpeed);
    }
}
