package models;

import interfaces.LeutenantGeneral;
import interfaces.Private;
import utilities.Printer;

import java.util.Set;

public class LeutenantGeneralImpl extends PrivateImpl implements Private, LeutenantGeneral {

    private Set<Private> privates;

    public LeutenantGeneralImpl(String firstName, String lastName, String id, double salary, Set<Private> privates) {
        super(firstName, lastName, id, salary);
        this.privates = privates;
    }

    @Override
    public Set<Private> getPrivates() {
        return this.privates;
    }

    @Override
    public String toString() {
        if (privates.size() < 1) {
            return String.format("%s%nPrivates:",
                    super.toString());
        } else {
            return String.format("%s%nPrivates:%n%s",
                    super.toString(),
                    Printer.collectionToString(privates));
        }

    }
}
