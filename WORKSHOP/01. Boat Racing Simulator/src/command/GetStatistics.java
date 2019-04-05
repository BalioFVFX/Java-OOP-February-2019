package command;

import data.race.RaceRepository;
import exception.*;
import model.boat.Boat;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class GetStatistics implements Command{

    private RaceRepository raceRepository ;

    public GetStatistics(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    @Override
    public String execute() throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, ArgumentException, NoSetRaceException, InsufficientContestantsException {
        Set<Boat> boats = this.raceRepository.getParticipants();

        LinkedHashMap<String, Double> statistics = new LinkedHashMap<>();

        for (Boat boat: boats) {
            String boatType = boat.getClass().getSimpleName();
            if(statistics.containsKey(boatType)){
                statistics.put(boatType, statistics.get(boatType) + 1);
            }
            else{
                statistics.put(boatType, 1.0);
            }
        }

        TreeMap<String, Double> results = new TreeMap<>();
        for (Map.Entry<String, Double> entry : statistics.entrySet()) {
            results.put(entry.getKey(), (entry.getValue() / 5) * 100);
        }

        StringBuilder output = new StringBuilder();

        for (Map.Entry<String, Double> entry : results.entrySet()) {
            output.append(entry.getKey()).append(" -> ").append(String.format("%.2f", entry.getValue()))
                    .append("%")
                    .append("\n");
        }
        output.replace(output.length() - 1, output.length(), "");
        return output.toString();
    }
}
