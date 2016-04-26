package by.epam.finaltask.facultative.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Admin on 26.04.2016.
 */
public class ControllerLocal extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getSession(true).setAttribute("local", request.getParameter("local"));
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

}
