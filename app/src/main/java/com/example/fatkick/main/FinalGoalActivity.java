package com.example.fatkick.main;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;


import com.example.fatkick.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FinalGoalActivity extends AppCompatActivity {

    private TextView tvInvalidInput;
    private Button btSaveGoal;
    private EditText etWeight;
    private FinalGoal finalGoal;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_goal);

        bindUI();

        btSaveGoal.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                String sWeight = etWeight.getText().toString();
                Double fWeight = Double.parseDouble(sWeight);
                user = new User("fabiha", 22, 52.2, 152, "female", "fabihahaider4@gmail.com");

                if(calculateBMI(fWeight) > 16 && calculateBMI(fWeight) < 30) {
                    finalGoal = new FinalGoal(user, fWeight);
                    tvInvalidInput.setVisibility(View.VISIBLE);
                    tvInvalidInput.setText("Deadline " + finalGoal.getDeadline());
                }
                else if (calculateBMI(fWeight) <= 16)
                {
                    tvInvalidInput.setVisibility(View.VISIBLE);
                    tvInvalidInput.setText("Underweight");
                }
                else
                {
                    tvInvalidInput.setVisibility(View.VISIBLE);
                    tvInvalidInput.setText("Overweight");
                }

//                Log.i("fabiha", "onClick: BMI "+ finalGoal.getBMI() + " LOCAL DATE " + finalGoal.getDeadline());
            }
        });
    }

    private void bindUI() {
        etWeight = findViewById(R.id.et_weight);
        btSaveGoal = findViewById(R.id.bt_save_goal);
        tvInvalidInput = findViewById(R.id.tv_invalid_input);
    }

    private double calculateBMI(double dweight) {
        double BMI = ( dweight / (user.getHeight() * user.getHeight()) ) * 10000;
        return BMI;
    }
}