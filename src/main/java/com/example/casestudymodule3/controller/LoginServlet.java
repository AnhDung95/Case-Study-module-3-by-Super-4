package com.example.casestudymodule3.controller;

import com.example.casestudymodule3.model.Role;
import com.example.casestudymodule3.model.Users;
import com.example.casestudymodule3.service.implementService.BookServiceImplement;
import com.example.casestudymodule3.service.implementService.UsersServiceImplement;
import com.example.casestudymodule3.service.interfaceService.IBookService;
import com.example.casestudymodule3.service.interfaceService.IUsersService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/auth")
public class LoginServlet extends HttpServlet {
    private final IUsersService iUsersService = new UsersServiceImplement();
    private final IBookService iBookService = new BookServiceImplement();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        action(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        action(req, resp);
    }

    private void action(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        System.out.println(action);
        if (action == null)
            action = "";
        switch (action) {
            case "registration":
                registration(req, resp);
                break;
            case "login":
                login(req, resp);
                break;
        }
    }

    private void registration(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("username");
        String password= req.getParameter("password");
        Users u = new Users(
               account,
                password,
                "",
                "",
                "",
                "",
                req.getParameter("email"),
                Role.USER
        );
        iUsersService.add(u);
        HttpSession session = req.getSession();
//            session.getAttribute("userID", userID);
        session.setAttribute("account", account);
        session.setAttribute("password", password);
        resp.sendRedirect("/admin?action=showBook");
//        RequestDispatcher rd = req.getRequestDispatcher("/admin/book.jsp");
//        rd.forward(req, resp);
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        System.out.println(account);
        System.out.println(password);
        Users users = new Users(account, password);
        int userID = iUsersService.findByUser(users);
        System.out.println(userID);
        if (userID == -1) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("login/index.jsp");
            String message = "Account or password is invalid";
            req.setAttribute("message", message);
            dispatcher.forward(req, resp);
        } else {
            Users users1 = iUsersService.findById(userID);
            Role role = users1.getRole();
            HttpSession session = req.getSession();
//            session.getAttribute("userID", userID);
            session.setAttribute("account", account);
            session.setAttribute("password", password);
            session.setAttribute("role", role);
            if (role == Role.ADMIN) {
                resp.sendRedirect("/admin");
            } else if (role == Role.USER) {
                resp.sendRedirect("/admin?action=showBook");
            }
        }
    }
}