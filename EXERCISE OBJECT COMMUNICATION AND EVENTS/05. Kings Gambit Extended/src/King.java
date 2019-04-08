import java.util.ArrayList;
import java.util.List;

public class King extends Entity implements Defensible, OnSoldierKilledListener {

    private List<Soldier> observables;


    public King(String name) {
        super(name);
        this.observables = new ArrayList<>();
    }

    @Override
    public void defend() {
        System.out.printf("King %s is under attack!%n", super.getName());
    }


    public void addObservableSoldiers(List<Soldier> soldiers){
        soldiers.forEach(soldier -> soldier.setonSoldierKilledListener(this));
        this.observables.addAll(soldiers);
    }

    public void fireEvents(){
        this.defend();
        this.observables.forEach(Defensible::defend);
    }

    public void killObservable(String name){
        this.observables.stream().filter(s -> s.getName().equals(name)).findFirst().ifPresent(Soldier::takeDamage);

    }

    @Override
    public void onKilled(Soldier soldier) {
        this.observables.remove(soldier);
    }
}
