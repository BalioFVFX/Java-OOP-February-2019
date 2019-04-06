package commands;

import models.Target;
import observers.ObservableTarget;

public class NotifyCommand implements Command {

    private ObservableTarget target;

    public NotifyCommand(ObservableTarget target) {
        this.target = target;
    }

    @Override
    public void execute() {
        this.target.notifyObservers();
    }
}
