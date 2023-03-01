package com.example.fitnessappws.dao;

import com.example.fitnessappws.mapper.WorkoutMapper;
import com.example.fitnessappws.model.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class WorkoutJDBC implements WorkoutDAO {
    JdbcTemplate jdbcTemplate;
    WorkoutMapper workoutMapper;

    @Autowired
    public WorkoutJDBC(JdbcTemplate jdbcTemplate, WorkoutMapper workoutMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.workoutMapper = workoutMapper;
    }

    @Override
    public void addWorkout(Workout workout) {
        String sql = "INSERT INTO workout (name, duration, difficulty) " +
                "VALUES (?,?,?);";
        jdbcTemplate.update(sql, workout.getName(),
                workout.getDuration(),
                workout.getDifficulty());

    }

    @Override
    public Optional<Workout> getWorkout(int id) {
        String sql = "SELECT * FROM workout WHERE id = ?";
        Workout workout = null;
        try {
            workout = jdbcTemplate.queryForObject(sql, workoutMapper, id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(workout);
    }

    @Override
    public List<Workout> getAllWorkouts() {
        String sql = "SELECT * FROM workout";
        return jdbcTemplate.query(sql, workoutMapper);
    }

    @Override
    public List<Workout> listWorkoutsByName(String name) {
        String sql = "SELECT * FROM workout WHERE name = ?";
        return jdbcTemplate.query(sql, workoutMapper, name);
    }

    @Override
    public void updateWorkout(Workout workout, int id) {
        String sql = "UPDATE workout SET name = ?, duration = ?, difficulty = ? " +
                "WHERE id = ?";
        jdbcTemplate.update(sql, workout.getName(), workout.getDuration(),
                workout.getDifficulty(), id);
    }

    @Override
    public void deleteWorkout(int id) {
        String sql = "DELETE FROM workout WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
