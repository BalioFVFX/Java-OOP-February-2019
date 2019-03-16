package models;

import enums.Corps;

public class SpecialisedSoldier extends PrivateImpl {

    private Corps corps;

    public SpecialisedSoldier(String firstName, String lastName, String id, double salary, Corps corps) {
        super(firstName, lastName, id, salary);
        this.corps = corps;
    }


    public Corps getCorps() {
        return corps;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Corps: " + getCorps().name();
    }
}
