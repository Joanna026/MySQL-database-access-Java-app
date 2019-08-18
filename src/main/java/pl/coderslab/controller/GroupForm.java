package pl.coderslab.controller;

import pl.coderslab.model.Group;
import pl.coderslab.model.GroupDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/groupform")
public class GroupForm extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        String newName = request.getParameter("name");

        GroupDAO groupDAO = new GroupDAO();
        Group group = new Group(newName);
        if (groupId==0){
            groupDAO.create(group);
        } else {
           group.setId(groupId);
            groupDAO.update(group);
        }

        Group[] groupList = groupDAO.findAll();
        request.setAttribute("groupList", groupList);

        getServletContext().getRequestDispatcher("/WEB-INF/grouplist.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int groupId = Integer.parseInt(request.getParameter("groupId"));
        GroupDAO groupDAO = new GroupDAO();
        if (groupId==0){
            Group group = new Group(0,null);
            request.setAttribute("groupToEdit", group);
        } else {
            Group group = groupDAO.read(groupId);
            request.setAttribute("groupToEdit", group);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/groupedition.jsp").forward(request, response);
    }
}
