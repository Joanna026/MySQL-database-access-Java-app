package pl.coderslab.controller;

import pl.coderslab.model.Exercise;
import pl.coderslab.model.ExerciseDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/exerciselist")
public class ExerciseList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ExerciseDAO exerciseDAO = new ExerciseDAO();
        Exercise[] exerciseList = exerciseDAO.findAll();

        request.setAttribute("exerciseList", exerciseList);
        getServletContext().getRequestDispatcher("/WEB-INF/exerciselist.jsp").forward(request, response);
    }
}
