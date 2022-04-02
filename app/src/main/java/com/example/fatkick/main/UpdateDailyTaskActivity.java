package com.example.fatkick.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.fatkick.R;

public class UpdateDailyTaskActivity extends AppCompatActivity {


    Spinner spinnerActivityLevel;
    EditText calorieIntake;
    EditText waterIntake;
    EditText sleep;
    EditText meditation;
    Button saveButton;
    DailyActivity dailyActivity;

    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_daily_task);

        spinnerActivityLevel =findViewById(R.id.spinner);
        adapter=ArrayAdapter.createFromResource(this, R.array.activity_levels, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerActivityLevel.setAdapter(adapter);

        calorieIntake =(EditText) findViewById(R.id.et_calorie_intake);
        waterIntake =(EditText) findViewById(R.id.et_water_intake);
        meditation =(EditText) findViewById(R.id.et_meditation);
        sleep =(EditText) findViewById(R.id.et_sleep);
        saveButton = (Button) findViewById(R.id.bt_save);

        dailyActivity= new DailyActivity(0.0, "0%", 0.0, 0.0, 0.0);


        saveButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dailyActivity.setCalorieIntake(Double.parseDouble(calorieIntake.getText().toString().trim()));
                dailyActivity.setActivityLevel(spinnerActivityLevel.getSelectedItem().toString().trim());
                dailyActivity.setWaterIntake(Double.parseDouble(waterIntake.getText().toString().trim()));
                dailyActivity.setMeditation(Double.parseDouble(meditation.getText().toString().trim()));
                dailyActivity.setSleep(Double.parseDouble(sleep.getText().toString().trim()));


                //save to database, store progress in firebase
                Log.i("tuba", dailyActivity.getCalorieIntake().toString());
                Log.i("tuba", dailyActivity.getActivityLevel().toString());
                Log.i("tuba", dailyActivity.getWaterIntake().toString());
                Log.i("tuba", dailyActivity.getMeditation().toString());
                Log.i("tuba", dailyActivity.getSleep().toString());

                finish();

            }
        });





    }
}