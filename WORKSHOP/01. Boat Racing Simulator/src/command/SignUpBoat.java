package command;

import data.race.RaceRepository;
import data.vehicles.BoatRepository;
import exception.*;
import model.boat.Boat;
import model.race.Race;

public class SignUpBoat extends BaseCommand {

    private final BoatRepository boatRepository;
    private RaceRepository raceRepository;

    public SignUpBoat(BoatRepository boatRepository, RaceRepository raceRepository, String[] data) {
        super(data);
        this.boatRepository = boatRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String execute() throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, ArgumentException, NoSetRaceException {

        Boat boat = this.boatRepository.findByModel(getData()[1]);
        this.raceRepository.signUpBoat(boat);

        return String.format("Boat with model %s has signed up for the current Race.",
                boat.getModel());
    }
}
