/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.demoapp.dao.impl;

import com.abc.demoapp.dao.CourseDAO;
import com.abc.demoapp.dbutil.DBConnection;
import com.abc.demoapp.entity.Course;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zak
 */
public class CourseDAOImpl implements CourseDAO {

    DBConnection db = new DBConnection();

    @Override
    public List<Course> getAll() throws ClassNotFoundException, SQLException {
        List<Course> courseList = new ArrayList<>();
        db.open();
        String sql = "SELECT * FROM courses";
        db.initStatement(sql);
        ResultSet rs = db.executeQuery();
        while (rs.next()) {
            Course course = new Course();
            course.setId(rs.getInt("course_id"));
            course.setName(rs.getString("course_name"));
            course.setDescription(rs.getString("description"));
            course.setFees(rs.getInt("fees"));
            course.setStatus(rs.getBoolean("status"));
            courseList.add(course);
        }
        db.close();
        return courseList;
    }

    @Override
    public int insert(Course course) throws ClassNotFoundException, SQLException {
        db.open();
        String sql = "INSER INTO courses(course_name, description, fees, status) VALUES(?,?,?,?)";
        PreparedStatement stmt = db.initStatement(sql);
        stmt.setString(1, course.getName());
        stmt.setString(2, course.getDescription());
        stmt.setInt(3, course.getFees());
        stmt.setBoolean(4, course.isStatus());
        int result = db.executeUpdate();
        db.close();
        return result;
    }

}
