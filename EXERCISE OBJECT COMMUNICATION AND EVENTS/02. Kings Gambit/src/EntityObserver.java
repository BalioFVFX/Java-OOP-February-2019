import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class EntityObserver {
    private List<Entity> observers;

    public EntityObserver() {
        this.observers = new ArrayList<>();
    }


    public void addObservable(Entity observable){
        this.observers.add(observable);
    }

    public void removeObservable(String name){
        this.observers = this.observers.stream().filter(entity -> !entity.getName().equals(name)).collect(Collectors.toList());
    }

    public void fireEvents(){
        this.observers.forEach(Defensible::defend);
    }

    public void addObservables(List<Entity> observables){
        this.observers.addAll(observables);
    }
}
