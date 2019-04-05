package command;

import data.race.RaceRepository;
import exception.*;
import model.boat.Boat;
import model.race.Race;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StartRace implements Command {

    private RaceRepository raceRepository;

    public StartRace(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    @Override
    public String execute() throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, ArgumentException, NoSetRaceException, InsufficientContestantsException {

        return raceRepository.startRace();
    }
}
