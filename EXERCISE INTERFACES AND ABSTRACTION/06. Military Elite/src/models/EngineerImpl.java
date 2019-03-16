package models;

import enums.Corps;
import interfaces.Engineer;
import interfaces.Repair;
import utilities.Printer;

import java.util.Set;

public class EngineerImpl extends SpecialisedSoldier implements Engineer {
    private Set<Repair> repairs;
    public EngineerImpl(String firstName, String lastName, String id, double salary, Corps corps, Set<Repair> repairs) {
        super(firstName, lastName, id, salary, corps);
        this.repairs = repairs;
    }

    @Override
    public Set<Repair> getRepairs() {
        return this.repairs;
    }

    @Override
    public String toString() {
        if(repairs.size() < 1){
            return String.format("%s%nRepairs:",
                    super.toString());
        }
        else{
            return String.format("%s%nRepairs:%n%s",
                    super.toString(),
                    Printer.collectionToString(repairs));
        }
    }
}
