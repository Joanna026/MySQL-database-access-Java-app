package pl.coderslab.controller;

import pl.coderslab.model.GroupDAO;
import pl.coderslab.model.User;
import pl.coderslab.model.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/showusers")
public class ShowUsers extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        UserDAO userDAO = new UserDAO();
        User[] users = userDAO.findAllByGroup(groupId);
        request.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/WEB-INF/groupusers.jsp").forward(request, response);
    }


}
