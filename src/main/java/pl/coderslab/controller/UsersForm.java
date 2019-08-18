package pl.coderslab.controller;

import pl.coderslab.model.Group;
import pl.coderslab.model.GroupDAO;
import pl.coderslab.model.User;
import pl.coderslab.model.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet("/usersform")
public class UsersForm extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int group =Integer.parseInt(request.getParameter("groupId"));
        int userId = Integer.parseInt(request.getParameter("userId"));

        UserDAO userDAO = new UserDAO();
        User user = new User(name, email, password, group);
        if (userId == 0) {
            userDAO.create(user);
        } else {
            user.setId(userId);
            userDAO.update(user);
        }

        Set<String[]> usersList = UsersList.usersList();
        request.setAttribute("usersList", usersList);

        getServletContext().getRequestDispatcher("/WEB-INF/userslist.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int userId = Integer.parseInt(request.getParameter("userId"));
        UserDAO userDAO = new UserDAO();
        GroupDAO groupDAO = new GroupDAO();
        Group[] allGroups = groupDAO.findAll();
        request.setAttribute("allGroups", allGroups);
        if (userId == 0) {
            User user = new User(0);
            request.setAttribute("userToEdit", user);
        } else {
            User user = userDAO.read(userId);
            request.setAttribute("userToEdit", user);
        }

        getServletContext().getRequestDispatcher("/WEB-INF/useredition.jsp").forward(request, response);
    }
}
