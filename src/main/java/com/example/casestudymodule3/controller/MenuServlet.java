package com.example.casestudymodule3.controller;

import com.example.casestudymodule3.model.Book;
import com.example.casestudymodule3.model.Category;
import com.example.casestudymodule3.model.Publishers;
import com.example.casestudymodule3.service.implementService.BookServiceImplement;
import com.example.casestudymodule3.service.implementService.CategoryServiceImplement;
import com.example.casestudymodule3.service.implementService.PublishersServiceImplement;
import com.example.casestudymodule3.service.interfaceService.IBookService;
import com.example.casestudymodule3.service.interfaceService.ICategoryService;
import com.example.casestudymodule3.service.interfaceService.IPublishersService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MenuServlet", urlPatterns = "/menu")
public class MenuServlet extends HttpServlet {
    private final IBookService bookService = new BookServiceImplement();
    private final IPublishersService publishersService = new PublishersServiceImplement();
    private final ICategoryService iCategoryService = new CategoryServiceImplement();
    private final List<Publishers> publishers = publishersService.getAll();
    private final List<Category> categories = iCategoryService.getAll();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request,response);

        String action = request.getParameter("action");
        if(action == null) {
            action = "";
        }
        switch (action) {
            case "store":
                storeAll(request,response);
                break;
            case "textbooks":
                storeTextbooks(request,response);
                break;
            case "novel":
                storeNovel(request,response);
                break;
            case "comic":
                storeComic(request,response);
                break;
            case "search":
                findByKeyword(request,response);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request,response);
    }

    private void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    }

    private void findByKeyword(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        String keyword = request.getParameter("search");
//        String name= request.getParameter("name");
        List<Book> books = bookService.findByKeyword(keyword);
        request.setAttribute("publishers",publishers);
        request.setAttribute("categories",categories);
        request.setAttribute("book",books);
//        request.getRequestDispatcher("result.jsp").forward(request,response);
            RequestDispatcher dispatcher=request.getRequestDispatcher("admin/result.jsp");
            dispatcher.forward(request,response);
    }

    private void storeComic(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        List<Book> books = bookService.findByKeyword("truyen tranh");
        request.setAttribute("activen4","active");
        request.setAttribute("publishers",publishers);
        request.setAttribute("categories",categories);
        request.setAttribute("book", books);
        request.getRequestDispatcher("client/view/store.jsp").forward(request,response);
    }

    private void storeNovel(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        List<Book> books = bookService.findByKeyword("tieu thuyet");
        request.setAttribute("activen3","active");
        request.setAttribute("publishers",publishers);
        request.setAttribute("categories",categories);
        request.setAttribute("book", books);
        request.getRequestDispatcher("client/view/store.jsp").forward(request,response);
    }

    private void storeTextbooks(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        List<Book> books = bookService.findByKeyword("sach giao khoa");
        request.setAttribute("activen2","active");
        request.setAttribute("publishers",publishers);
        request.setAttribute("categories",categories);
        request.setAttribute("book", books);
        request.getRequestDispatcher("client/view/store.jsp").forward(request,response);
    }

    private void storeAll(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        List<Book> books = bookService.getAll();
        request.setAttribute("activen1","active");
        request.setAttribute("publishers",publishers);
        request.setAttribute("categories",categories);
        request.setAttribute("book",books);
        request.getRequestDispatcher("client/view/store.jsp").forward(request,response);

    }

}