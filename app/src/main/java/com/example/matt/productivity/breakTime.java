package com.example.matt.productivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class breakTime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_break_time);

        AlarmManager alarm = (AlarmManager)getSystemService(ALARM_SERVICE);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int workMin = bundle.getInt("work");
        int breakMin = bundle.getInt("break");

        Intent toWorking = new Intent(this, working.class);
        Bundle workBundle = new Bundle();
        workBundle.putInt("work", workMin);
        workBundle.putInt("break", breakMin);
        toWorking.putExtras(workBundle);

        //PendingIntent breakTime = PendingIntent.getActivity(this, 0, toBreakTime, PendingIntent.FLAG_CANCEL_CURRENT);
        PendingIntent workTime = PendingIntent.getActivity(this, 0, toWorking, 0);
        alarm.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                breakMin*60*1000,
                workTime);
    }
}
