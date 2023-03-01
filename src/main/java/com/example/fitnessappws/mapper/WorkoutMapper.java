package com.example.fitnessappws.mapper;


import com.example.fitnessappws.model.Workout;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkoutMapper implements RowMapper<Workout> {
    @Override
    public Workout mapRow(ResultSet rs, int rowNum) throws SQLException {
        Workout workout = new Workout();
        workout.setId(rs.getInt("id"));
        workout.setName(rs.getString("name"));
        workout.setDuration(rs.getInt("duration"));
        workout.setDifficulty(rs.getString("difficulty"));

        return workout;
    }
}
