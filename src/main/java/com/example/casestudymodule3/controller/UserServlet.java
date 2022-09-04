package com.example.casestudymodule3.controller;

import com.example.casestudymodule3.model.Book;
import com.example.casestudymodule3.model.Category;
import com.example.casestudymodule3.model.Role;
import com.example.casestudymodule3.model.Users;
import com.example.casestudymodule3.service.implementService.BookServiceImplement;
import com.example.casestudymodule3.service.implementService.CategoryServiceImplement;
import com.example.casestudymodule3.service.implementService.UsersServiceImplement;
import com.example.casestudymodule3.service.interfaceService.IBookService;
import com.example.casestudymodule3.service.interfaceService.ICategoryService;
import com.example.casestudymodule3.service.interfaceService.IUsersService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/users")
public class UserServlet extends HttpServlet {
    private final IUsersService iUsersService = new UsersServiceImplement();
    private final IBookService iBookService = new BookServiceImplement();
//        chua co BookServiceImplement
    private final ICategoryService categoryService = new CategoryServiceImplement();
    private final List<Category> categories = categoryService.getAll();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request, response);
    }
    private void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null)
            action = "";

        switch (action) {
            case "books":
                getAllBooks(request,response);
                break;
            case "add":
                addBooks(request,response);
                break;
            case "delete":
                deleteBooks(request,response);
                break;
            case "edit":
                editBooks(request,response);
                break;
            case "findByPublishers":
                findBooksByCategory(request,response);
                break;
            default:
                display(request,response);
        }

    }
    private void getAllBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = iBookService.getAll();
        request.setAttribute("books", books);
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("admin/books.jsp").forward(request,response);
    }

    private void addBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String describe = request.getParameter("describe");
        String author = request.getParameter("author");
        int idCategory = Integer.parseInt(request.getParameter("category"));
        int idPublishers = Integer.parseInt(request.getParameter("publishers"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String img = request.getParameter("img");
        Book book = new Book(name,describe,author,quantity,img);
        boolean check = iBookService.add(book,idCategory,idPublishers);
        request.setAttribute("checkAdd", check);
        List<Book> books = iBookService.getAll();
        request.setAttribute("books", books);
        request.setAttribute("categories",categories);
        request.getRequestDispatcher("admin/books.jsp").forward(request,response);
    }

    private void deleteBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean checkDelete = iBookService.delete(id);
        List<Book> books = iBookService.getAll();
        request.setAttribute("books", books);
        request.setAttribute("checkDel", checkDelete);
        request.setAttribute("categories",categories);
        request.getRequestDispatcher("admin/books.jsp").forward(request,response);
    }
        private void editBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String describe = request.getParameter("describe");
        String author = request.getParameter("author");
        int idCategory = Integer.parseInt(request.getParameter("category"));
        int idPublishers = Integer.parseInt(request.getParameter("publishers"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String img = request.getParameter("img");
        Book book = new Book(name,describe,author,quantity,img);
        boolean check = iBookService.update(id,book,idCategory,idPublishers);
        request.setAttribute("checkEdit", check);
        List<Book> books = iBookService.getAll();
        request.setAttribute("categories",categories);
        request.setAttribute("books",books);
        request.getRequestDispatcher("admin/books.jsp").forward(request,response);
    }

    private void findBooksByCategory (HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
//        String category =request.getParameter(("category"));
        List<Book> books = iBookService.findByKeyword("category");
        request.setAttribute("books", books);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/books.jsp");
        dispatcher.forward(request,response);
    }

    private void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Users> users = iUsersService.getAll();
        List<Book> books = iBookService.getAll();
        request.setAttribute("users", users);
        request.setAttribute("books", books);
        request.getRequestDispatcher("admin/system.jsp").forward(request,response);
    }


}

