package com.example.fatkick.main;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class FinalGoal {
    private User user;
    private double BMI;
    private double weight;
    private LocalDate deadline;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public FinalGoal(User user, double weight) {
        this.user = user;
        this.weight = weight;
        this.deadline = calculateDeadline();
    }


    public double getBMI() {
        BMI = (weight / (user.getWeight() * user.getWeight()) ) * 10000;
        return BMI;
    }


    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public LocalDate getDeadline() {
        return deadline;
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public LocalDate calculateDeadline()
    {

       double weeks = user.getWeight() - weight;
       LocalDate today = LocalDate.now();
       deadline = today.plusDays(Math.round(weeks * 7));
       return deadline;
    }

}
