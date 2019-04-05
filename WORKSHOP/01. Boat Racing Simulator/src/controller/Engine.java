package controller;

import data.race.RaceRepository;
import data.vehicles.BoatRepository;
import data.vehicles.EngineRepository;
import exception.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine {
    private BoatRepository boatRepository;
    private EngineRepository engineRepository;
    private RaceRepository raceRepository;
    private Handler commandHandler;

    public Engine(BoatRepository boatRepository, EngineRepository engineRepository, RaceRepository raceRepository) {
        this.boatRepository = boatRepository;
        this.engineRepository = engineRepository;
        this.raceRepository = raceRepository;
        this.commandHandler = new CommandHandler(engineRepository, boatRepository, raceRepository);
    }


    public void run() throws IOException, DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, NoSetRaceException, ArgumentException, InsufficientContestantsException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        while (!input.equals("End")){
            String[] data = input.split("\\\\");

            try{
                this.commandHandler.handle(data);
            }
            catch (Exception ex){
                System.out.println(ex.getMessage());
            }


            input = bufferedReader.readLine();
        }
    }
}
