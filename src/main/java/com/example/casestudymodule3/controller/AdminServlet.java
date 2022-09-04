package com.example.casestudymodule3.controller;

<<<<<<< HEAD
import com.example.casestudymodule3.model.Book;
import com.example.casestudymodule3.model.Category;
import com.example.casestudymodule3.model.Role;
import com.example.casestudymodule3.model.Users;
import com.example.casestudymodule3.service.implementService.BookServiceImplement;
import com.example.casestudymodule3.service.implementService.CategoryServiceImplement;
import com.example.casestudymodule3.service.implementService.UsersServiceImplement;
import com.example.casestudymodule3.service.interfaceService.IBookService;
import com.example.casestudymodule3.service.interfaceService.ICategoryService;
=======
import com.example.casestudymodule3.model.*;
import com.example.casestudymodule3.service.implementService.BookServiceImplement;
import com.example.casestudymodule3.service.implementService.CategoryServiceImplement;
import com.example.casestudymodule3.service.implementService.PublishersServiceImplement;
import com.example.casestudymodule3.service.implementService.UsersServiceImplement;
import com.example.casestudymodule3.service.interfaceService.IBookService;
import com.example.casestudymodule3.service.interfaceService.ICategoryService;
import com.example.casestudymodule3.service.interfaceService.IPublishersService;
>>>>>>> master
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
<<<<<<< HEAD
    private final List<Users> users=iUsersService.getAll();
//    private final ICategoryService categoryService = new CategoryServiceImplement();
//    private final List<Category> categories = categoryService.getAll();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request, response);

    }
=======
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

>>>>>>> master
    private void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null)
            action = "";

        switch (action) {
<<<<<<< HEAD
            case "users":
                getAllUsers(request,response);
                break;
            case "addUser":
                addUser(request,response);
                break;
            case "editUser":
                editUsers(request,response);
                break;
            case "deleteUser":
                deleteUsers(request,response);
=======
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
>>>>>>> master
                break;
            case "customers":
                getAllCustomer(request,response);
                break;
<<<<<<< HEAD
            case "active":
                activeAccount(request,response);
                break;
            case "blocked":
                blockedAccount(request,response);
=======
//            case "active":
//                activeAccount(request,response);
//                break;
//            case "blocked":
//                blockedAccount(request,response);
>>>>>>> master
            default:
                display(request,response);
        }

    }
<<<<<<< HEAD
    private void getAllUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Users> users = iUsersService.getAll();
        request.setAttribute("users", users);
        request.getRequestDispatcher("admin/users.jsp").forward(request,response);
    }

        private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int Id = Integer.parseInt(request.getParameter("Id"));
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        Users  user = new Users(Id,account,password,firstName,lastName,address,phone,email);
        boolean check = iUsersService.add(user,Id);
        request.setAttribute("checkAddUser", check);
        List<Users> users = iUsersService.getAll();
        request.setAttribute("users", users);
        request.getRequestDispatcher("admin/users.jsp").forward(request,response);
    }

        private void editUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int Id = Integer.parseInt(request.getParameter("Id"));
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        Users  user = new Users(Id,account,password,firstName,lastName,address,phone,email);
        int id = Integer.parseInt(request.getParameter("id"));
        boolean check = iUsersService.update(id,user);
        request.setAttribute("checkEditUser", check);
        List<Users> users = iUsersService.getAll();
        request.setAttribute("users", users);
        request.getRequestDispatcher("admin/users.jsp").forward(request,response);
    }

        private void deleteUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean checkDelete = iUsersService.delete(id);
        List<Users> users = iUsersService.getAll();
        request.setAttribute("users", users);
        request.setAttribute("checkDelUser", checkDelete);
        request.getRequestDispatcher("admin/users.jsp").forward(request,response);
    }

    private void blockedAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Users users = iUsersService.findById(id);
//        users.setStatus(Status.BLOCKED);
        boolean check = iUsersService.update(id,users);
        request.setAttribute("checkBlock",check);
        getAllUsers(request,response);
    }

    private void activeAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Users users = iUsersService.findById(id);
//        users.setStatus(Status.ACTIVE);
        boolean check = iUsersService.update(id,users);
        request.setAttribute("checkActive",check);
        getAllUsers(request,response);
    }
//
//
//    private void getAllTablets(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Product> tablets = iProductService.findByKeyword("tablet");
//        request.setAttribute("products", tablets);
//        request.setAttribute("categories",categories);
//        request.setAttribute("brands",brands);
//        request.getRequestDispatcher("admin/products.jsp").forward(request,response);
//    }
//
//    private void getAllSmartPhones(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Product> smartPhones = iProductService.findByKeyword("SmartPhone");
//        request.setAttribute("products", smartPhones);
//        request.setAttribute("categories",categories);
//        request.setAttribute("brands",brands);
//        request.getRequestDispatcher("admin/products.jsp").forward(request,response);
//    }
//
//    private void getAllLaptops(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Product> laptops = iProductService.findByKeyword("laptop");
//        request.setAttribute("products", laptops);
//        request.setAttribute("categories",categories);
//        request.setAttribute("brands",brands);
//        request.getRequestDispatcher("admin/products.jsp").forward(request,response);
//    }

    private void getAllCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
=======

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
>>>>>>> master
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
<<<<<<< HEAD
    private void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<Users> users = iUsersService.getAll();
    List<Book> books = iBookService.getAll();
    request.setAttribute("users", users);
    request.setAttribute("books", books);
    request.getRequestDispatcher("admin/system.jsp").forward(request,response);
}
//
//    private void getAllProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Product> products = iProductService.getAll();
//        request.setAttribute("products", products);
//        request.setAttribute("categories", categories);
//        request.setAttribute("brands", brands);
//        request.getRequestDispatcher("admin/products.jsp").forward(request,response);
//    }
//

//
//    private void editGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Product product = iProductService.findById(id);
//        request.setAttribute("brands",brands);
//        request.setAttribute("categories",categories);
//        request.setAttribute("product", product);
//        request.getRequestDispatcher("admin/edit.jsp").forward(request,response);
//    }
//

//

=======

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
>>>>>>> master
}
