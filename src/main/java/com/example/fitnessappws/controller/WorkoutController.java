package com.example.fitnessappws.controller;

import com.example.fitnessappws.dao.WorkoutDAO;
import com.example.fitnessappws.model.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {
    private final WorkoutDAO workoutDAO;

    @Autowired
    public WorkoutController(WorkoutDAO workoutDAO) {
        this.workoutDAO = workoutDAO;
    }

    @GetMapping
    public List<Workout> getAllWorkouts() {
        return workoutDAO.getAllWorkouts();
    }

    @RequestMapping(params = {"q"}, method = RequestMethod.GET)
    public List<Workout> listWorkoutsByName(@RequestParam(value = "q") String q) {
        return workoutDAO.listWorkoutsByName(q);
    }

    @GetMapping("/{id}")
    public Optional<Workout> getWorkoutById(@PathVariable("id") int id) {
        return workoutDAO.getWorkout(id);
    }

    @PostMapping
    public long addWorkout(@RequestBody Workout workout) {
        return workoutDAO.addWorkout(workout);
    }

    @DeleteMapping("/{id}")
    public void deleteWorkout(@PathVariable("id") int id) {
        workoutDAO.deleteWorkout(id);
    }
}
