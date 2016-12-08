/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.demoapp.controller.admin;

import com.abc.demoapp.dao.CourseDAO;
import com.abc.demoapp.dao.impl.CourseDAOImpl;
import com.abc.demoapp.entity.Course;
import com.abc.demoapp.system.Controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author zak
 */
@WebServlet(name = "addcourse", urlPatterns = {"/admin/addcourse"})
public class AddCourse extends Controller {
    CourseDAO courseDAO = new CourseDAOImpl();
    String path = "/WEB-INF/views/admin/";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(path + "addcourse.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Course course = new Course();
        course.setName(request.getParameter("name"));
        course.setDescription(request.getParameter("description"));
        course.setFees(Integer.parseInt(request.getParameter("fees")));
        course.setStatus(request.getParameter("status") != null);
        try {
            courseDAO.insert(course);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddCourse.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddCourse.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.sendRedirect(request.getContextPath() + "/admin/dashboard");
    }
    

}
