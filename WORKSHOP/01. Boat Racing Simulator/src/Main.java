import controller.Engine;
import data.race.RaceRepository;
import data.vehicles.BoatRepository;
import data.vehicles.EngineRepository;
import exception.*;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws DuplicateModelException, IOException, NonExistantModelException, ArgumentException, NoSetRaceException, InsufficientContestantsException, RaceAlreadyExistsException {
        Engine engine = new Engine(new BoatRepository(), new EngineRepository(), new RaceRepository());

        engine.run();
    }
}
