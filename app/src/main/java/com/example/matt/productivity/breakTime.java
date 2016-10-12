package com.example.matt.productivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class breakTime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_break_time);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int workMin = bundle.getInt("work");
        int breakMin = bundle.getInt("break");

        final Intent toWorking = new Intent(this, working.class);
        Bundle workBundle = new Bundle();
        workBundle.putInt("work", workMin);
        workBundle.putInt("break", breakMin);
        toWorking.putExtras(workBundle);

        new Timer().schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        startActivity(toWorking);
                    }
                },
                workMin * 60 * 1000
        );
    }
}
