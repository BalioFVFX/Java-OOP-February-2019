package controller;

import command.*;
import data.race.RaceRepository;
import data.vehicles.BoatRepository;
import data.vehicles.EngineRepository;
import exception.*;

public class CommandHandler implements Handler {

    private final EngineRepository engineRepository;
    private final BoatRepository boatRepository;
    private final RaceRepository raceRepository;

    public CommandHandler(EngineRepository engineRepository, BoatRepository boatRepository, RaceRepository raceRepository) {
        this.engineRepository = engineRepository;
        this.boatRepository = boatRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public void handle(String[] data) throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, ArgumentException, NoSetRaceException, InsufficientContestantsException {
        String commandType = data[0];

        Command command = null;
        switch (commandType) {
            case "CreateBoatEngine":
                command = new CreateBoatEngine(data, engineRepository);
                break;
            case "CreateRowBoat":
                command = new CreateRowBoat(data, boatRepository);
                break;
            case "CreateSailBoat":
                command = new CreateSailBoat(data, boatRepository);
                break;
            case "CreatePowerBoat":
                command = new CreatePowerBoat(data, boatRepository, engineRepository);
                break;
            case "CreateYacht":
                command = new CreateYachtBoat(data, boatRepository, engineRepository);
                break;
            case "OpenRace":
                command = new OpenRace(data, raceRepository);
                break;
            case "SignUpBoat":
                command = new SignUpBoat(boatRepository, raceRepository, data);
                break;
            case "StartRace":
                command = new StartRace(raceRepository);
                break;
            case "GetStatistic":
                command = new GetStatistics(raceRepository);
                break;
            default:
                break;
        }
        this.execute(command);
    }

    @Override
    public void execute(Command command) throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, ArgumentException, NoSetRaceException, InsufficientContestantsException {
        String result = command.execute();
        System.out.println(result);
    }
}
