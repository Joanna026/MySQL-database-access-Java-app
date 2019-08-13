package pl.coderslab.controller;

import pl.coderslab.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet("/userdata")
public class ShowUserData extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        UserDAO userDAO = new UserDAO();
        User user = userDAO.read(userId);
        request.setAttribute("user", user);

        GroupDAO groupDAO = new GroupDAO();
        Group group = groupDAO.read(user.getUser_group_id());
        request.setAttribute("groupName", group.getName());

        SolutionDAO solutionDAO = new SolutionDAO();
        Set<String[]> userSolutions = solutionDAO.findSolutionsByUser(userId);
        request.setAttribute("userSolutions", userSolutions);

        getServletContext().getRequestDispatcher("/WEB-INF/userdata.jsp").forward(request, response);
    }
}
