package com.example.fatkick.main;

import android.provider.ContactsContract;

public class User {
    private String name;
    private double age;
    private double weight;
    private double height;
    private String gender;
    private String email;

    public User(String name, float age, double weight, double height, String gender, String email) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.gender = gender;
        this.email = email;
    }

    private boolean isValid()
    {
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(float age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
