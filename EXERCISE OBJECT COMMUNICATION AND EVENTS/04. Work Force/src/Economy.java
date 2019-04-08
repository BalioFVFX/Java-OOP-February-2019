import employees.base.Employee;
import job.Job;
import listeners.JobListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class Economy implements JobListener {
    private List<Job> jobs;
    private LinkedHashMap<String, Employee> employees;

    public Economy() {
        this.jobs = new ArrayList<>();
        this.employees = new LinkedHashMap<>();
    }

    public void addJob(Job job){
        job.setJobListener(this);
        this.jobs.add(job);
    }

    public void passWeek(){
        Job[] jobsToUpdate = new Job[jobs.size()];
        jobs.toArray(jobsToUpdate);

        for (int i = 0; i < jobsToUpdate.length; i++) {
            jobsToUpdate[i].update();
        }
    }

    public void addEmployee(Employee employee){
        this.employees.put(employee.getName(), employee);
    }

    public Employee getEmployeeByName(String name){
        return this.employees.get(name);
    }

    public void getStatus(){
        for (Job job : jobs) {
            System.out.printf("Job: %s Hours Remaining: %d%n", job.getName(), job.getReamingHours());
        }
    }

    @Override
    public void onJobComplete(Job job) {
        System.out.printf("Job %s done!%n", job.getName());
        this.jobs.remove(job);
    }
}
