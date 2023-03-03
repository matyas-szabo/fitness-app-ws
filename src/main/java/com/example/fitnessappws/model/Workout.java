package com.example.fitnessappws.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Workout {
    private int id;
    private String name;
    private int duration;
    private Difficulty difficulty;

    public Workout(int id, String name, int duration, String difficulty) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.setDifficulty(Difficulty.valueOf(difficulty));
    }
}