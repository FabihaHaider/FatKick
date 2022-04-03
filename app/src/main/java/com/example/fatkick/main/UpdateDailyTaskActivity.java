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
import android.widget.Toast;

import com.example.fatkick.R;

public class UpdateDailyTaskActivity extends AppCompatActivity {


    Spinner spinnerActivityLevel;
    EditText calorieIntake;
    EditText waterIntake;
    EditText sleep;
    EditText meditation;

    EditText swimming;
    EditText running;
    EditText walking;
    EditText cycling;
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

        swimming =(EditText) findViewById(R.id.et_swimming);
        running =(EditText) findViewById(R.id.et_running);
        walking =(EditText) findViewById(R.id.et_walking);
        cycling =(EditText) findViewById(R.id.et_cycling);
        saveButton = (Button) findViewById(R.id.bt_save);



        dailyActivity= new DailyActivity(0.0, "0%", 0.0, 0.0, 0.0);


        saveButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String sCalIntake = calorieIntake.getText().toString().trim();
                String sWaterIntake =waterIntake.getText().toString().trim();
                String sActivityLevel =spinnerActivityLevel.getSelectedItem().toString().trim();
                String sMeditation =meditation.getText().toString().trim();
                String sSleep =sleep.getText().toString().trim();

                String sSwimming =swimming.getText().toString().trim();
                String sRunning =running.getText().toString().trim();
                String sWalking =walking.getText().toString().trim();
                String sCycling =cycling.getText().toString().trim();




                if(sCalIntake.equals("")||sActivityLevel.equals("")||sWaterIntake.equals("")||sMeditation.equals("")||sSleep.equals("")
                    ||sSwimming.equals("")||sRunning.equals("")||sWalking.equals("")||sCycling.equals("")) {

                    Toast.makeText(getApplicationContext(), "Please fill up all fields.", Toast.LENGTH_LONG).show();
                }

                else{

                    dailyActivity.setCalorieIntake(Double.parseDouble(calorieIntake.getText().toString().trim()));
                    dailyActivity.setActivityLevel(spinnerActivityLevel.getSelectedItem().toString().trim());
                    dailyActivity.setWaterIntake(Double.parseDouble(waterIntake.getText().toString().trim()));
                    dailyActivity.setMeditation(Double.parseDouble(meditation.getText().toString().trim()));
                    dailyActivity.setSleep(Double.parseDouble(sleep.getText().toString().trim()));

                    dailyActivity.addExercise(new Exercise("swimming", Double.parseDouble(swimming.getText().toString().trim())));
                    dailyActivity.addExercise(new Exercise("running", Double.parseDouble(running.getText().toString().trim())));
                    dailyActivity.addExercise(new Exercise("walking", Double.parseDouble(walking.getText().toString().trim())));
                    dailyActivity.addExercise(new Exercise("cycling", Double.parseDouble(cycling.getText().toString().trim())));


                    //save to database, store progress in firebase
                    Log.i("tuba", dailyActivity.getCalorieIntake().toString());
                    Log.i("tuba", dailyActivity.getActivityLevel().toString());
                    Log.i("tuba", dailyActivity.getWaterIntake().toString());
                    Log.i("tuba", dailyActivity.getMeditation().toString());
                    Log.i("tuba", dailyActivity.getSleep().toString());

                    Log.i("tuba", dailyActivity.getExercise()[0].getType() + dailyActivity.getExercise()[0].getDuration().toString());
                    Log.i("tuba", dailyActivity.getExercise()[3].getType() + dailyActivity.getExercise()[3].getDuration().toString());

                    finish();

                }
            }

        });





    }
}