package command;

import data.vehicles.BoatRepository;
import exception.ArgumentException;
import exception.DuplicateModelException;
import model.boat.Boat;
import model.boat.RowBoat;

public class CreateRowBoat extends BaseCommand {

    private BoatRepository boatRepository;

    public CreateRowBoat(String[] data, BoatRepository boatRepository) {
        super(data);
        this.boatRepository = boatRepository;
    }

    @Override
    public String execute() throws DuplicateModelException, ArgumentException {
        String model = getData()[1];
        int weight = Integer.parseInt(getData()[2]);
        int oars = Integer.parseInt(getData()[3]);

        Boat rowBoat = new RowBoat(model, weight, oars);

        this.boatRepository.addEntry(rowBoat);

        return String.format("%s with model %s registered successfully.",
                "Row boat",
                model);
    }
}
