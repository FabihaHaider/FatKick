package com.example.fatkick.main;

public class DailyActivity {
    private Double calorieIntake; //in Kcal
    private String activityLevel; //
    private Double waterIntake;   //in L
    private Double sleep;         //in hour
    private Double meditation;    //in minutes


    private Exercise[] exercise;

    public DailyActivity(Double calorieIntake, String activityLevel, Double waterIntake, Double sleep, Double meditation) {
        this.calorieIntake = calorieIntake;
        this.activityLevel = activityLevel;
        this.waterIntake = waterIntake;
        this.sleep = sleep;
        this.meditation = meditation;
    }

    public Double getCalorieIntake() {
        return calorieIntake;
    }

    public void setCalorieIntake(Double calorieIntake) {
        this.calorieIntake = calorieIntake;
    }

    public String getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel;
    }

    public Double getWaterIntake() {
        return waterIntake;
    }

    public void setWaterIntake(Double waterIntake) {
        this.waterIntake = waterIntake;
    }

    public Double getSleep() {
        return sleep;
    }

    public void setSleep(Double sleep) {
        this.sleep = sleep;
    }

    public Double getMeditation() {
        return meditation;
    }

    public void setMeditation(Double meditation) {
        this.meditation = meditation;
    }

    public Exercise[] getExercise() {
        return exercise;
    }

    public void setExercise(Exercise[] exercise) {
        this.exercise = exercise;
    }
}
