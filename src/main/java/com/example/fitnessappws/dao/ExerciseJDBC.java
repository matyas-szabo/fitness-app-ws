package com.example.fitnessappws.dao;

import com.example.fitnessappws.mapper.ExerciseMapper;
import com.example.fitnessappws.model.Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ExerciseJDBC implements ExerciseDAO {
    JdbcTemplate jdbcTemplate;
    ExerciseMapper exerciseMapper;

    @Autowired
    public ExerciseJDBC(JdbcTemplate jdbcTemplate, ExerciseMapper exerciseMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.exerciseMapper = exerciseMapper;
    }

    @Override
    public void addExercise(Exercise exercise) {
        String sql = "INSERT INTO exercise (name, calories_burned, muscle_group) " +
                "VALUES (?,?,?);";
        jdbcTemplate.update(sql, exercise.getName(),
                exercise.getCalories_burned(),
                exercise.getMuscle_group());

    }

    @Override
    public Optional<Exercise> getExercise(int id) {
        String sql = "SELECT * FROM exercise WHERE id = ?";
        Exercise exercise = null;
        try {
            exercise = jdbcTemplate.queryForObject(sql, exerciseMapper, id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(exercise);
    }

    @Override
    public List<Exercise> getAllExercises() {
        String sql = "SELECT * FROM exercise";
        return jdbcTemplate.query(sql, exerciseMapper);
    }

    @Override
    public void updateExercise(Exercise exercise, int id) {
        String sql = "UPDATE exercise SET name = ?, calories_burned = ?, muscle_group = ? " +
                "WHERE id = ?";
        jdbcTemplate.update(sql, exercise.getName(), exercise.getCalories_burned(),
                exercise.getMuscle_group(), id);
    }

    @Override
    public void deleteExercise(int id) {
        String sql = "DELETE FROM exercise WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
