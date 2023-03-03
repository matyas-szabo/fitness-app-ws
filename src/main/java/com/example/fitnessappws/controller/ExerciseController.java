package com.example.fitnessappws.controller;

import com.example.fitnessappws.dao.ExerciseDAO;
import com.example.fitnessappws.model.Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/exercises")
public class ExerciseController {
    private final ExerciseDAO exerciseDAO;

    @Autowired
    public ExerciseController(ExerciseDAO exerciseDAO) {
        this.exerciseDAO = exerciseDAO;
    }

    @GetMapping
    public List<Exercise> getAllExercises() {
        return exerciseDAO.getAllExercises();
    }

    @GetMapping("/{id}")
    public Optional<Exercise> getExerciseById(@PathVariable("id") int id) {
        return exerciseDAO.getExercise(id);
    }

    @PostMapping
    public long addExercise(@RequestBody Exercise exercise) {
        return exerciseDAO.addExercise(exercise);
    }

    @DeleteMapping("/{id}")
    public void deleteExercise(@PathVariable("id") int id) {
        exerciseDAO.deleteExercise(id);
    }
}
