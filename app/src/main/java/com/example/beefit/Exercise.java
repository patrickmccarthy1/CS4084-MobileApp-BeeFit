package com.example.beefit;

import java.io.Serializable;

public class Exercise implements Serializable {
    private String exercise_name;
    private String exercise_type;
    private String met1;
    private String met2;
    private String calories_burned;

    public Exercise(String exercise_name, String exercise_type, String met1, String met2, String calories_burned) {
        this.exercise_name = exercise_name;
        this.exercise_type = exercise_type;
        this.met1 = met1;
        this.met2 = met2;
        this.calories_burned = calories_burned;
    }

    public String getExercise_name() {
        return exercise_name;
    }

    public String getExercise_type() { return exercise_type; }

    public String getMet1() {
        return met1;
    }


    public String getMet2() {
        return met2;
    }


    public String getCalories_burned() {
        return calories_burned;
    }

}
