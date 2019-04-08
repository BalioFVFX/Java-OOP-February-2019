package job;

import employees.base.Employee;
import listeners.JobListener;

import java.util.Objects;

public class Job {
    private Employee employee;
    private int reamingHours;
    private String name;
    private JobListener jobListener;

    public Job(String name, int reamingHours, Employee employee) {
        this.setName(name);
        this.setReamingHours(reamingHours);
        this.setEmployee(employee);
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getReamingHours() {
        return reamingHours;
    }

    public void setReamingHours(int reamingHours) {
        this.reamingHours = reamingHours;
    }

    public void update(){
        this.reamingHours -= this.employee.work();

        if(this.reamingHours <= 0){
            jobListener.onJobComplete(this);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setJobListener(JobListener jobListener){
        this.jobListener = jobListener;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return Objects.equals(name, job.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
