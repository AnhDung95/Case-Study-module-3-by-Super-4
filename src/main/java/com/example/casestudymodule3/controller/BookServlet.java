package com.example.casestudymodule3.controller;

import com.example.casestudymodule3.model.Book;
import com.example.casestudymodule3.model.Publishers;
import com.example.casestudymodule3.model.Review;
import com.example.casestudymodule3.service.implementService.BookServiceImplement;
import com.example.casestudymodule3.service.implementService.PublishersServiceImplement;
import com.example.casestudymodule3.service.implementService.ReviewServiceImplement;
import com.example.casestudymodule3.service.interfaceService.IBookService;
import com.example.casestudymodule3.service.interfaceService.IPublishersService;
import com.example.casestudymodule3.service.interfaceService.IReviewService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookServlet", urlPatterns = "/home")
public class BookServlet extends HttpServlet {
    private final IBookService bookService = new BookServiceImplement();
    private final IReviewService reviewService = new ReviewServiceImplement();
    private final IPublishersService publishersService = new PublishersServiceImplement();
    private final List<Publishers> publishers = publishersService.getAll();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request,response);
    }

    private void action(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "detail":
                findById(request,response);
                break;
            case "textbooks":
                textbooksHome(request,response);
                break;
            case "novel":
                novelHome(request,response);
                break;
            case "comic":
                comicHome(request,response);
                break;
            default:
                allBookHome(request,response);
                break;
        }
    }

    private void allBookHome(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        List<Book> books = bookService.getAll();
        List<Book> textbooks = bookService.findByKeyword("sach giao khoa");
        List<Book> novel = bookService.findByKeyword("tieu thuyet");
        List<Book> comic = bookService.findByKeyword("truyen tranh");
        request.setAttribute("active1", "active");
        request.setAttribute("book", books);
        request.setAttribute("publishers", publishers);
        request.setAttribute("textbooks", textbooks);
        request.setAttribute("novel", novel);
        request.setAttribute("comic", comic);
        RequestDispatcher rd = request.getRequestDispatcher("client/view/index.jsp");
        rd.forward(request, response);
    }

    private void comicHome(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        List<Book> books = bookService.findByKeyword("truyen tranh");
        List<Book> textbooks = bookService.findByKeyword("sach giao khoa");
        List<Book> novel = bookService.findByKeyword("tieu thuyet");
        List<Book> comic = bookService.findByKeyword("truyen tranh");
        request.setAttribute("active3", "active");
        request.setAttribute("book", books);
        request.setAttribute("publishers", publishers);
        request.setAttribute("textbooks", textbooks);
        request.setAttribute("novel", novel);
        request.setAttribute("comic", comic);
        request.getRequestDispatcher("client/view/index.jsp").forward(request, response);
    }

    private void novelHome(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        List<Book> books = bookService.findByKeyword("tieu thuyet");
        List<Book> textbooks = bookService.findByKeyword("sach giao khoa");
        List<Book> novel = bookService.findByKeyword("tieu thuyet");
        List<Book> comic = bookService.findByKeyword("truyen tranh");
        request.setAttribute("active4", "active");
        request.setAttribute("book", books);
        request.setAttribute("publishers", publishers);
        request.setAttribute("textbooks", textbooks);
        request.setAttribute("novel", novel);
        request.setAttribute("comic", comic);
        request.getRequestDispatcher("client/view/index.jsp").forward(request, response);
    }

    private void textbooksHome(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        List<Book> books = bookService.findByKeyword("Sach giao khoa");
        List<Book> textbooks = bookService.findByKeyword("sach giao khoa");
        List<Book> novel = bookService.findByKeyword("tieu thuyet");
        List<Book> comic = bookService.findByKeyword("truyen tranh");
        request.setAttribute("active2", "active");
        request.setAttribute("book", books);
        request.setAttribute("textbooks", textbooks);
        request.setAttribute("novel", novel);
        request.setAttribute("comic", comic);
        request.getRequestDispatcher("client/view/index.jsp").forward(request, response);
    }

    private void findById(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = bookService.findById(id);
        List<Review> reviews = reviewService.findListReviewById(id);
        request.setAttribute("publishers",publishers);
        request.setAttribute("reviews",reviews);
        request.setAttribute("book",book);
        request.getRequestDispatcher("admin/book.jsp").forward(request,response);
    }

}