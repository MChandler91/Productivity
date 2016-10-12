package com.example.matt.productivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class main_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    }

    protected void startWork(View v) {
        Intent intent = new Intent(this,working.class);
        Bundle bundle = new Bundle();
        int workTime = Integer.parseInt(((TextView) findViewById(R.id.workMinutes)).getText().toString());
        int breakTime = Integer.parseInt(((TextView) findViewById(R.id.breakMinutes)).getText().toString());
        bundle.putInt("work", workTime);
        bundle.putInt("break", breakTime);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
