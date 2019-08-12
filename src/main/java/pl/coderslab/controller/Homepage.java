package pl.coderslab.controller;

import pl.coderslab.model.Solution;
import pl.coderslab.model.SolutionDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/homepage")
public class Homepage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int limit =Integer.parseInt(getServletContext().getInitParameter("numberSolutions"));
        SolutionDAO solutionDAO = new SolutionDAO();
        String[][] recentSolutions = solutionDAO.findRecent(limit);
        request.setAttribute("solutions", recentSolutions);

        getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }
}
