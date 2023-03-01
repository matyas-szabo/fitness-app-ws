package com.example.fitnessappws.dao;

import com.example.fitnessappws.model.Exercise;

import java.util.List;

public interface ExerciseDAO {
    void addExercise(Exercise exercise);

    Exercise getExercise(int id);

    List<Exercise> getAllExercises();

    void updateExercise(Exercise exercise, int id);

    void deleteExercise(int id);


}

