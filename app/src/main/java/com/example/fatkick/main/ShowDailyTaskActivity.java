package com.example.fatkick.main;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.fatkick.R;

import java.util.ArrayList;

public class ShowDailyTaskActivity extends AppCompatActivity implements DailyActivityController.DailyActivityCallback {

    /* this should be taken from database*/
    Number age=25;
    String gender = "male";
    Number height = 180;
    Number weight = 70;
    String activity_level = "level_1";


    DailyActivity dailyActivity;
    TextView mtv_calorie_intake;
    TextView mtv_activity_level;
    TextView mtv_water_intake;
    TextView mtv_meditation;
    TextView mtv_sleep;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_daily_task);

        mtv_calorie_intake = (TextView) findViewById(R.id.tv_calorie_intake);
        mtv_activity_level = (TextView) findViewById(R.id.tv_activity_level);
        mtv_water_intake = (TextView) findViewById(R.id.tv_water_intake);
        mtv_meditation = (TextView) findViewById(R.id.tv_meditation);
        mtv_sleep = (TextView) findViewById(R.id.tv_sleep);

        DailyActivityController dailyActivityController = new DailyActivityController();
        dailyActivityController.generateDailyActivity(age,gender,height,weight,activity_level);
        dailyActivityController.setActivityCallback(this);

    }

    @Override
    public void updateDailyActivity(DailyActivity dailyActivity) {
        Log.i("tuba", dailyActivity.getCalorieIntake().toString()+" from update");

        ShowDailyTaskActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //Handle UI here
                mtv_calorie_intake.setText("Calorie Intake(Net): "+dailyActivity.getCalorieIntake().toString()+" kcal");
                mtv_activity_level.setText("Activity Level: "+dailyActivity.getActivityLevel().toString());
                mtv_water_intake.setText("Water Intake: Try to drink at least "+dailyActivity.getWaterIntake().toString()+" liters");
                mtv_meditation.setText("Meditation: Try to meditate at least "+dailyActivity.getMeditation().toString()+" minutes");
                mtv_sleep.setText("Sleep: Try to sleep at least "+dailyActivity.getSleep().toString()+" hours");
            }
        });

    }


}