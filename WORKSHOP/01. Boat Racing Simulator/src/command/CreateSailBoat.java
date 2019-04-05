package command;

import data.vehicles.BoatRepository;
import exception.ArgumentException;
import exception.DuplicateModelException;
import model.boat.Boat;
import model.boat.SailBoat;

public class CreateSailBoat extends BaseCommand {

    private final BoatRepository boatRepository;

    public CreateSailBoat(String[] data, BoatRepository boatRepository){
        super(data);
        this.boatRepository = boatRepository;
    }

    @Override
    public String execute() throws DuplicateModelException, ArgumentException {
        String model = getData()[1];
        int weight = Integer.parseInt(getData()[2]);
        int sailEfficiency = Integer.parseInt(getData()[3]);

        Boat sailBoat = new SailBoat(model, weight, sailEfficiency);

        this.boatRepository.addEntry(sailBoat);

        return String.format("%s with model %s registered successfully.",
                "Sail boat",
                model);
    }
}
