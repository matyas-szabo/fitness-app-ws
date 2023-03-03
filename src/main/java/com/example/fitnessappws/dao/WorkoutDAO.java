package com.example.fitnessappws.dao;

import com.example.fitnessappws.model.Workout;

import java.util.List;
import java.util.Optional;

public interface WorkoutDAO {

    long addWorkout(Workout workout);

    Optional<Workout> getWorkout(int id);

    List<Workout> getAllWorkouts();

    List<Workout> listWorkoutsByName(String name);

    void updateWorkout(Workout workout, int id);

    void deleteWorkout(int id);
}
