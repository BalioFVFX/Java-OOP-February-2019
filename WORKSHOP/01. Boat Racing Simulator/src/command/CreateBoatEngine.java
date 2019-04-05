package command;

import data.vehicles.EngineRepository;
import exception.ArgumentException;
import exception.DuplicateModelException;
import model.engine.Engine;
import model.engine.JetEngine;
import model.engine.SterndriveEngine;

public class CreateBoatEngine extends BaseCommand {
    private EngineRepository engineRepository;

    public CreateBoatEngine(String[] data, EngineRepository engineRepository) {
        super(data);
        this.engineRepository = engineRepository;
    }

    @Override
    public String execute() throws DuplicateModelException, ArgumentException {
        String model = getData()[1];
        int horsePower = Integer.parseInt(getData()[2]);
        int displacement = Integer.parseInt(getData()[3]);
        String engineType = getData()[4];
        Engine engine = this.createEngineObject(model, horsePower, displacement, engineType);
        this.engineRepository.addEntry(engine);

        return String.format("Engine model %s with %d HP and displacement %d cm3 created successfully.",
                model,
                horsePower,
                displacement);

    }

    private Engine createEngineObject(String model, int horsePower, int displacement, String engineType) throws ArgumentException {
        switch (engineType) {
            case "Jet":
                return new JetEngine(model, horsePower, displacement);
            case "Sterndrive":
                return new SterndriveEngine(model, horsePower, displacement);
            default:
                return null;
        }
    }
}
