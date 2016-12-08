/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abc.demoapp.controller.admin;

import com.abc.demoapp.dao.CourseDAO;
import com.abc.demoapp.dao.impl.CourseDAOImpl;
import com.abc.demoapp.system.Controller;
import java.io.IOException;
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
@WebServlet(name = "admindash", urlPatterns = {"/admin/dashboard"})
public class Dashbaord extends Controller {

    private CourseDAO courseDAO = new CourseDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "/WEB-INF/views/admin/";
        String page = "index.jsp";

        try {
            request.setAttribute("courses", courseDAO.getAll());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dashbaord.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Dashbaord.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.getRequestDispatcher(path + page).forward(request, response);
    }

}
