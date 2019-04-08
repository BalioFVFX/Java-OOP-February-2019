package employees;

import employees.base.Employee;

public class StandardEmployee extends Employee {

    private static final int WORK_HOURS_PER_WEEK = 40;

    public StandardEmployee(String name) {
        super(name, WORK_HOURS_PER_WEEK);
    }
}
