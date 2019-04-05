package command;

import exception.*;

public interface Command {
    String execute() throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, ArgumentException, NoSetRaceException, InsufficientContestantsException;
}
