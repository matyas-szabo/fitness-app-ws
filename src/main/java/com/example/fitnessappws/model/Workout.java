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
    private String difficulty;


}
