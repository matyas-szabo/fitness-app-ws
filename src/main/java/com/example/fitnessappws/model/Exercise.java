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
    private int calories_burned;
    private String muscle_group;

}
