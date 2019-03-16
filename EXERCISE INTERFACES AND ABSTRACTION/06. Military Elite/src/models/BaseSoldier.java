package models;

import interfaces.Solider;

public abstract class BaseSoldier implements Solider {

    private String id;
    private String firstName;
    private String lastName;

    public BaseSoldier(String firstName, String lastName, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %s",
                this.getFirstName(),
                this.getLastName(),
                this.getId());
    }
}
