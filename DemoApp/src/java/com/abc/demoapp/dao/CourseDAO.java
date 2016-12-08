/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.demoapp.dao;

import com.abc.demoapp.entity.Course;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author zak
 */
public interface CourseDAO {

    int insert(Course course) throws ClassNotFoundException, SQLException;

    List<Course> getAll() throws ClassNotFoundException, SQLException;
}
