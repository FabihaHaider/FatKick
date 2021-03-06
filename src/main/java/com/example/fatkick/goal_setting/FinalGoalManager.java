package com.example.fatkick.main.goal_setting;

import com.example.fatkick.main.authenticator.User;
import com.example.fatkick.main.goal_setting.FinalGoal;

public class FinalGoalManager {
    private User user;
    private FinalGoal finalGoal;


    public FinalGoalManager(User user, FinalGoal finalGoal) {
        this.user = user;
        this.finalGoal = finalGoal;
    }

    public FinalGoalManager(User user)
    {
        this.user = user;
    }

    public double calculateBMI() {
        double BMI = ( finalGoal.getWeight() / (user.getHeight() * user.getHeight()) ) * 10000;
        return BMI;
    }


    public String suggestGoal()
    {
        double lower_bound = (16 * user.getHeight() * user.getHeight()) /10000;
        double upper_bound = (30 * user.getHeight() * user.getHeight()) /10000;

        return Double.toString(lower_bound) + " kg to " + Double.toString(upper_bound)+ " kg.";
    }

    public String isGoalSafe()
    {
        double BMI = calculateBMI();

        if(BMI > 16 && BMI < 30)
            return "safe goal";
        else if(BMI <= 16)
            return "underweight";
        else
            return "overweight";

    }
}
