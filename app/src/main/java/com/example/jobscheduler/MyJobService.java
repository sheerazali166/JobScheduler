package com.example.jobscheduler;

// TODO: Created by Sheeraz 16/08/2024

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.widget.Toast;

public class MyJobService extends JobService {
    @Override
    public boolean onStartJob(JobParameters jobParameters) {

        Toast.makeText(this, "Job started", Toast.LENGTH_SHORT).show();
        
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {

        Toast.makeText(this, "Job finished", Toast.LENGTH_SHORT).show();

        return false;
    }
}
