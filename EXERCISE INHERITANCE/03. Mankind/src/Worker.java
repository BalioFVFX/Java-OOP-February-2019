import java.security.InvalidParameterException;

public class Worker extends Human {

    private double weekSalary;
    private double workHoursPerDay;

    public Worker(String firstName, String lastName, double weekSalary, double workHoursPerDay) {
        super.setFirstName(firstName);
        this.setLastName(lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    private void setLastName(String lastName) {
        if (lastName.length() < 3) {
            throw new InvalidParameterException("Expected length more than 3 symbols!Argument: lastName");
        }

        super.lastName = lastName;
    }

    private void setWeekSalary(double weekSalary) {
        if (weekSalary <= 10) {
            throw new InvalidParameterException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    private void setWorkHoursPerDay(double workHoursPerDay) {
        if (workHoursPerDay < 1 || workHoursPerDay > 12) {
            throw new InvalidParameterException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workHoursPerDay = workHoursPerDay;
    }

    @Override
    public String toString() {
        return String.format("%s%nWeek salary: %.2f%nHours per day: %.2f%nSalary per hour: %.2f",
                super.toString(),
                this.weekSalary,
                this.workHoursPerDay,
                (this.weekSalary / this.workHoursPerDay) / 7);
    }
}
