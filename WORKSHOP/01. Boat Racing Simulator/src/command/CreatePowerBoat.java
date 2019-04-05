package command;

import data.vehicles.BoatRepository;
import data.vehicles.EngineRepository;
import exception.ArgumentException;
import exception.DuplicateModelException;
import exception.NonExistantModelException;
import model.boat.Boat;
import model.boat.motorboat.PowerBoat;
import model.engine.Engine;

public class CreatePowerBoat extends BaseCommand{
    private BoatRepository boatRepository;
    private EngineRepository engineRepository;

    public CreatePowerBoat(String[] data, BoatRepository boatRepository, EngineRepository engineRepository) {
        super(data);
        this.boatRepository = boatRepository;
        this.engineRepository = engineRepository;
    }

    @Override
    public String execute() throws DuplicateModelException, NonExistantModelException, ArgumentException {
        String model = getData()[1];
        int weight = Integer.parseInt(getData()[2]);
        Engine firstEngine = this.engineRepository.findByModel(getData()[3]);
        Engine secondEngine = this.engineRepository.findByModel(getData()[4]);

        Boat powerBoat = new PowerBoat(model, weight, firstEngine, secondEngine);

        this.boatRepository.addEntry(powerBoat);

        return String.format("%s with model %s registered successfully.",
                "Power boat",
                model);

    }
}
