package employees;

import employees.base.Employee;

public class PartTimeEmployee extends Employee {

    private static final int WORK_HOURS_PER_WEEK = 20;

    public PartTimeEmployee(String name) {
        super(name, WORK_HOURS_PER_WEEK);
    }
}
