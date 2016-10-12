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

public class working extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_working);

        AlarmManager alarm = (AlarmManager)getSystemService(ALARM_SERVICE);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int workMin = bundle.getInt("work");
        int breakMin = bundle.getInt("break");

        Intent toBreakTime = new Intent(this, breakTime.class);
        Bundle breakBundle = new Bundle();
        breakBundle.putInt("work", workMin);
        breakBundle.putInt("break", breakMin);
        toBreakTime.putExtras(breakBundle);

        //PendingIntent breakTime = PendingIntent.getActivity(this, 0, toBreakTime, PendingIntent.FLAG_CANCEL_CURRENT);
        PendingIntent breakTime = PendingIntent.getActivity(this, 0, toBreakTime, 0);
        alarm.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                workMin*60*1000,
                breakTime);

    }


}
