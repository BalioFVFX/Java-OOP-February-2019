package models;

import enums.Corps;
import interfaces.Commando;
import interfaces.Mission;
import utilities.Printer;

import java.rmi.activation.ActivationGroupDesc;
import java.util.Set;

public class CommandoImpl extends SpecialisedSoldier implements Commando {

    private Set<Mission> missions;

    public CommandoImpl(String firstName, String lastName, String id, double salary, Corps corps, Set<Mission> missions) {
        super(firstName, lastName, id, salary, corps);
        this.missions = missions;
    }

    @Override
    public Set<Mission> getMissions() {
        return this.missions;
    }

    @Override
    public String toString() {
        if(missions.size() < 1){
            return String.format("%s%nMissions:",
                    super.toString());
        }
        else{
            return String.format("%s%nMissions:%n%s",
                    super.toString(),
                    Printer.collectionToString(missions));
        }

    }
}
