package command;

import data.vehicles.BoatRepository;
import data.vehicles.EngineRepository;
import exception.ArgumentException;
import exception.DuplicateModelException;
import exception.NonExistantModelException;
import model.boat.Boat;
import model.boat.motorboat.Yacht;
import model.engine.Engine;

public class CreateYachtBoat extends BaseCommand{
    private BoatRepository boatRepository;
    private EngineRepository engineRepository;

    public CreateYachtBoat(String[] data, BoatRepository boatRepository, EngineRepository engineRepository) {
        super(data);
        this.boatRepository = boatRepository;
        this.engineRepository = engineRepository;
    }


    @Override
    public String execute() throws DuplicateModelException, NonExistantModelException, ArgumentException {
        String model = getData()[1];
        int weight = Integer.parseInt(getData()[2]);
        Engine engine = this.engineRepository.findByModel(getData()[3]);
        int cargoWeight = Integer.parseInt(getData()[4]);

        Boat yacht = new Yacht(model, weight, engine, cargoWeight);

        this.boatRepository.addEntry(yacht);

        return String.format("%s with model %s registered successfully.",
                "Yacht",
                model);
    }
}
