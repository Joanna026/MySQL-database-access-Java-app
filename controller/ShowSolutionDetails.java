package pl.coderslab.controller;

import pl.coderslab.model.Solution;
import pl.coderslab.model.SolutionDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/showdetails")
public class ShowSolutionDetails extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int solutionId =Integer.parseInt(request.getParameter("solutionId"));
        loadById(solutionId, request, response);
    }

    private void loadById(int solutionId,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SolutionDAO solutionDAO = new SolutionDAO();
        Solution solution = solutionDAO.read(solutionId);

        request.setAttribute("solution", solution);

        getServletContext().getRequestDispatcher("/WEB-INF/solutiondetails.jsp").forward(request, response);
    }
}