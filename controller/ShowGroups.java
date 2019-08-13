package pl.coderslab.controller;

import pl.coderslab.model.Group;
import pl.coderslab.model.GroupDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/grouplist")
public class ShowGroups extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("allGroups", loadAll(request, response));
        getServletContext().getRequestDispatcher("/WEB-INF/allgroups.jsp").forward(request, response);
    }

    private Group[] loadAll(HttpServletRequest request, HttpServletResponse response) {

        GroupDAO groupDAO = new GroupDAO();
        Group[] allGroups = groupDAO.findAll();

        return allGroups;
    }
}
