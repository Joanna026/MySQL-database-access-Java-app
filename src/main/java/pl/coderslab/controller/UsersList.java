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
import java.util.HashSet;
import java.util.Set;

@WebServlet("/userslist")
public class UsersList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Set<String[]> usersSet = usersList();
        request.setAttribute("usersList", usersSet);

        getServletContext().getRequestDispatcher("/WEB-INF/userslist.jsp").forward(request, response);
    }

    protected static Set<String[]> usersList() {
        UserDAO userDAO = new UserDAO();
        GroupDAO groupDAO = new GroupDAO();
        User[] usersList = userDAO.findAll();
        Set<String[]> usersSet=new HashSet<>();
        for (User user : usersList){
            Group group = groupDAO.read(user.getUser_group_id());
            String[] userData={user.getId() + "" , user.getUsername(), user.getEmail(), group.getName()};
            usersSet.add(userData);
        }
        return usersSet;
    }
}
