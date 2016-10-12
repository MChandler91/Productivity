package com.example.matt.productivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class working extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_working);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int workMin = bundle.getInt("work");
        int breakMin = bundle.getInt("break");

        final Intent toBreakTime = new Intent(this, breakTime.class);
        Bundle breakBundle = new Bundle();
        breakBundle.putInt("work", workMin);
        breakBundle.putInt("break", breakMin);
        toBreakTime.putExtras(breakBundle);

        new Timer().schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        startActivity(toBreakTime);
                    }
                },
                workMin * 60 * 1000
        );
    }


}
