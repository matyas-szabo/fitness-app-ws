package com.example.fitnessappws.dao;

import com.example.fitnessappws.model.Workout;

import java.util.List;

public interface WorkoutDAO {

    void addWorkout(Workout workout);

    Workout getWorkout(int id);

    List<Workout> getAllWorkouts();

    void updateWorkout(Workout workout, int id);

    void deleteWorkout(int id);
}
