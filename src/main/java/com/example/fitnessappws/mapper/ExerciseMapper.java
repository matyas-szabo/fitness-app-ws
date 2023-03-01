package com.example.fitnessappws.mapper;

import com.example.fitnessappws.model.Exercise;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExerciseMapper implements RowMapper<Exercise> {
    @Override
    public Exercise mapRow(ResultSet rs, int rowNum) throws SQLException {
        Exercise exercise = new Exercise();
        exercise.setId(rs.getInt("id"));
        exercise.setName(rs.getString("name"));
        exercise.setCalories_burned(rs.getInt("calories_burned"));
        exercise.setMuscle_group(rs.getString("muscle_group"));

        return exercise;
    }
}
