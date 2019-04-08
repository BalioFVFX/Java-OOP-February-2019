package listeners;

import job.Job;

public interface JobListener {
    void onJobComplete(Job job);
}
