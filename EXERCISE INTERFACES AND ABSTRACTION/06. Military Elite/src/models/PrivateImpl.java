package models;

import interfaces.Private;

public class PrivateImpl extends BaseSoldier implements Private {

    private double salary;

    public PrivateImpl(String firstName, String lastName, String id, double salary) {
        super(firstName, lastName, id);
        this.salary = salary;
    }


    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public int compareTo(Private o) {
        return o.getId().compareTo(this.getId());
    }

    @Override
    public String toString() {
        return String.format("%s Salary: %.2f",
                super.toString(),
                this.getSalary());
    }
}
