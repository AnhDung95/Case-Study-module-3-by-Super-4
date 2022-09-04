package com.example.casestudymodule3.controller;

import com.example.casestudymodule3.model.*;
import com.example.casestudymodule3.service.implementService.BookServiceImplement;
import com.example.casestudymodule3.service.implementService.CategoryServiceImplement;
import com.example.casestudymodule3.service.implementService.PublishersServiceImplement;
import com.example.casestudymodule3.service.implementService.UsersServiceImplement;
import com.example.casestudymodule3.service.interfaceService.IBookService;
import com.example.casestudymodule3.service.interfaceService.ICategoryService;
import com.example.casestudymodule3.service.interfaceService.IPublishersService;
import com.example.casestudymodule3.service.interfaceService.IUsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AdminServlet", urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
    private final IUsersService iUsersService = new UsersServiceImplement();
    private final IBookService iBookService = new BookServiceImplement();
    private final ICategoryService categoryService = new CategoryServiceImplement();
    private final IPublishersService publishersService = new PublishersServiceImplement();
    private final List<Publishers> publishers = publishersService.getAll();
    private final List<Category> categories = categoryService.getAll();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request,response);
    }

    private void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null)
            action = "";

        switch (action) {
            case "showBook":
                getAllBook(request,response);
                break;
            case "add":
                addBook(request,response);
                break;
            case "showFormEdit":
                editGet(request,response);
                break;
            case "edit":
                editBook(request,response);
                break;
            case "delete":
                deleteBook(request,response);
                break;
            case "textbooks":
                getAllTextbooks(request,response);
                break;
            case "novel":
                getAllNovel(request,response);
                break;
            case "comic":
                getAllComic(request,response);
                break;
            case "users":
                getAllUsers(request,response);
                break;
            case "admins":
                getAllAdmins(request,response);
                break;
            case "customers":
                getAllCustomer(request,response);
                break;
//            case "active":
//                activeAccount(request,response);
//                break;
//            case "blocked":
//                blockedAccount(request,response);
            default:
                display(request,response);
        }

    }

    private void getAllComic(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        List<Book> commic = iBookService.findByKeyword("truyen tranh");
        request.setAttribute("book",commic);
        request.setAttribute("category",categories);
        request.setAttribute("publishers",publishers);
        request.getRequestDispatcher("admin/book.jsp").forward(request,response);
    }

    private void getAllNovel(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        List<Book> novel = iBookService.findByKeyword("tieu thuyet");
        request.setAttribute("book",novel);
        request.setAttribute("category",categories);
        request.setAttribute("publishers",publishers);
        request.getRequestDispatcher("admin/book.jsp").forward(request,response);
    }

    private void getAllTextbooks(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        List<Book> textbooks = iBookService.findByKeyword("sach giao khoa");
        request.setAttribute("book",textbooks);
        request.setAttribute("category",categories);
        request.setAttribute("publishers",publishers);
        request.getRequestDispatcher("admin/book.jsp").forward(request,response);

    }

    private void display(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        List<Users> users = iUsersService.getAll();
        List<Book> books = iBookService.getAll();
        request.setAttribute("users", users);
        request.setAttribute("book", books);
        request.getRequestDispatcher("admin/system.jsp").forward(request,response);
    }

    private void getAllCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        List<Users> users = iUsersService.getAll();
        List<Users> customers = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getRole() == Role.USER){
                customers.add(users.get(i));
            }
        }
        request.setAttribute("users", customers);
        request.getRequestDispatcher("admin/users.jsp").forward(request,response);
    }

    private void getAllAdmins(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        List<Users> users = iUsersService.getAll();
        List<Users> admins = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getRole() == Role.ADMIN){
                admins.add(users.get(i));
            }
        }
        request.setAttribute("users", admins);
        request.getRequestDispatcher("admin/users.jsp").forward(request,response);
    }

    private void getAllUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        List<Users> users = iUsersService.getAll();
        request.setAttribute("users", users);
        request.getRequestDispatcher("admin/users.jsp").forward(request,response);
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean checkDelete = iBookService.delete(id);
        List<Book> books = iBookService.getAll();
        request.setAttribute("book", books);
        request.setAttribute("checkDel", checkDelete);
        request.setAttribute("categories",categories);
        request.setAttribute("publishers",publishers);
        request.getRequestDispatcher("admin/book.jsp").forward(request,response);
    }

    private void editBook(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        String describe = request.getParameter("describe");
        int categoryId = Integer.parseInt(request.getParameter("category"));
        int publishersId = Integer.parseInt(request.getParameter("publishers"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String imageURL = request.getParameter("imageURL");
        Book book = new Book(name,author,describe,quantity,imageURL);
        int id = Integer.parseInt(request.getParameter("id"));
        boolean check = iBookService.update(id ,book, categoryId,publishersId);
        request.setAttribute("checkEdit", check);
        List<Book> products = iBookService.getAll();
        request.setAttribute("categories",categories);
        request.setAttribute("publishers",publishers);
        request.setAttribute("book", book);
        request.getRequestDispatcher("admin/book.jsp").forward(request,response);
    }

    private void editGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = iBookService.findById(id);
        request.setAttribute("publishers",publishers);
        request.setAttribute("categories",categories);
        request.setAttribute("book", book);
        request.getRequestDispatcher("admin/edit.jsp").forward(request,response);
    }

    private void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String name = request.getParameter("name");
        String describe = request.getParameter("describe");
        String author = request.getParameter("author");
        int categoryId = Integer.parseInt(request.getParameter("category"));
        int publishersId = Integer.parseInt(request.getParameter("publishers"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String imgURL = request.getParameter("imageURL");
        Book book = new Book(name,describe,author,quantity,imgURL);
        boolean check = iBookService.add(book,categoryId,publishersId);
        request.setAttribute("checkAdd",check);
        List<Book> books = iBookService.getAll();
        request.setAttribute("book",books);
        request.setAttribute("category",categories);
        request.setAttribute("publishers",publishers);
        request.getRequestDispatcher("admin/book.jsp").forward(request,response);
    }

    private void getAllBook(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        List<Book> books = iBookService.getAll();
        request.setAttribute("book",books);
        request.setAttribute("category",categories);
        request.setAttribute("publishers",publishers);
        request.getRequestDispatcher("admin/book.jsp").forward(request,response);
    }
}
