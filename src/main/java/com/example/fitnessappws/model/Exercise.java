package com.example.fitnessappws.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exercise {
    private int id;
    private String name;
    private int caloriesBurned;
    private MuscleGroup muscleGroup;

    public Exercise(int id, String name, int calories_burned, String muscleGroup) {
        this.id = id;
        this.name = name;
        this.caloriesBurned = calories_burned;
        this.setMuscleGroup(MuscleGroup.valueOf(muscleGroup));
    }
}
