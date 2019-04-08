package employees.base;

public abstract class Employee {
    private String name;
    private int workHoursPerWeek;

    public Employee(String name, int workHoursPerWeek) {
        this.setName(name);
        this.setWorkHoursPerWeek(workHoursPerWeek);
    }

    public String getName(){
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }


    private void setWorkHoursPerWeek(int workHoursPerWeek) {
        this.workHoursPerWeek = workHoursPerWeek;
    }

    public int work(){
        return this.workHoursPerWeek;
    }
}
