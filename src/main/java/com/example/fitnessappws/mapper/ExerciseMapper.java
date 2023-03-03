package com.example.fitnessappws.mapper;

import com.example.fitnessappws.model.Exercise;
import com.example.fitnessappws.model.MuscleGroup;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ExerciseMapper implements RowMapper<Exercise> {
    @Override
    public Exercise mapRow(ResultSet rs, int rowNum) throws SQLException {
        Exercise exercise = new Exercise();
        exercise.setId(rs.getInt("id"));
        exercise.setName(rs.getString("name"));
        exercise.setCaloriesBurned(rs.getInt("calories_burned"));
        exercise.setMuscleGroup(MuscleGroup.valueOf(rs.getString("muscle_group")));

        return exercise;
    }
}
