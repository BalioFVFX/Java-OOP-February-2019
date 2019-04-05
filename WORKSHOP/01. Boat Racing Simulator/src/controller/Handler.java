package controller;

import command.Command;
import exception.*;

public interface Handler {
    void handle(String[] data) throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, ArgumentException, NoSetRaceException, InsufficientContestantsException;
    void execute(Command command) throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, ArgumentException, NoSetRaceException, InsufficientContestantsException;
}
