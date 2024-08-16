package com.example.jobscheduler;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final int JOB_ID = 1;
    private static final int REFRESH_INTERVAL = 5000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // TODO: Create Job Scheduler
        JobScheduler jobScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);

        // TODO: Create a component passing the job service that we want to use
        ComponentName jobServiceComponentName = new ComponentName(getPackageName(), MyJobService.class.getName());

        // TODO: Create a job info passing unique JOB_ID and the job service
        // TODO: also set the periodic time to repeat this job
        JobInfo jobInfo = new JobInfo.Builder(JOB_ID, jobServiceComponentName)
                .setPeriodic(REFRESH_INTERVAL).build();

        jobScheduler.schedule(jobInfo);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}