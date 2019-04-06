package commands;

import observers.Observable;
import observers.ObservableTarget;

public class RegisterObserverCommand implements Command {

    private ObservableTarget observableTarget;
    private Observable observable;

    public RegisterObserverCommand(ObservableTarget observableTarget, Observable observable) {
        this.observableTarget = observableTarget;
        this.observable = observable;
    }

    @Override
    public void execute() {
        this.observableTarget.register(observable);
    }
}
