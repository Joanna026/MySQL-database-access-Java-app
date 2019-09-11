package pl.coderslab.controller;

import pl.coderslab.model.Exercise;
import pl.coderslab.model.ExerciseDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/exerciseform")
public class ExerciseForm extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int exerciseId = Integer.parseInt(request.getParameter("exerciseId"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        ExerciseDAO exerciseDAO = new ExerciseDAO();
        Exercise exercise = new Exercise(name, description);
        if (exerciseId==0){
            exerciseDAO.create(exercise);
        } else {
            exercise.setId(exerciseId);
            exerciseDAO.update(exercise);
        }

        Exercise[] exerciseList = exerciseDAO.findAll();
        request.setAttribute("exerciseList", exerciseList);

        getServletContext().getRequestDispatcher("/WEB-INF/exerciselist.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int exerciseId = Integer.parseInt(request.getParameter("exerciseId"));
        ExerciseDAO exerciseDAO = new ExerciseDAO();
        if (exerciseId==0){
            Exercise exercise = new Exercise(0);
            request.setAttribute("exerciseToEdit", exercise);
        } else {
            Exercise exercise = exerciseDAO.read(exerciseId);
            request.setAttribute("exerciseToEdit", exercise);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/exerciseedition.jsp").forward(request, response);
    }
}
