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

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    private final IUsersService iUsersService = new UsersServiceImplement();
    private final IBookService iBookService = new BookServiceImplement();
//        chua co BookServiceImplement
    private final ICategoryService categoryService = new CategoryServiceImplement();
    //    private final IBrandService brandService = new BrandServiceImplement();
//    private final List<Brand> brands = brandService.getAll();
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
//            case "showFormEdit":
//                editGet(request,response);
//                break;
            case "edit":
                editBooks(request,response);
                break;
            case "delete":
                deleteProduct(request,response);
                break;
//            case "laptops":
//                getAllLaptops(request,response);
//                break;
//            case "smartphone":
//                getAllSmartPhones(request,response);
//                break;
//            case "tablet":
//                getAllTablets(request,response);
//                break;
            case "users":
                getAllUsers(request,response);
                break;
//            case "admins":
//                getAllAdmins(request,response);
//                break;
            case "customers":
                getAllCustomer(request,response);
                break;
            case "active":
                activeAccount(request,response);
                break;
            case "blocked":
                blockedAccount(request,response);
            default:
                display(request,response);
        }

    }
    private void getAllBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = iBookService.getAll();
        request.setAttribute("books", books);
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("admin/products.jsp").forward(request,response);
    }

    private void addBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String serial = request.getParameter("serial");
        String name = request.getParameter("name");
        int categoryId = Integer.parseInt(request.getParameter("category"));
        int brandId = Integer.parseInt(request.getParameter("brand"));
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String description = request.getParameter("description");
        String imageURL = request.getParameter("imageURL");
        Product  product = new Product(serial,name,price,quantity,description,imageURL);
        boolean check = iProductService.add(product, categoryId, brandId);
        request.setAttribute("checkAdd", check);
        List<Product> products = iProductService.getAll();
        request.setAttribute("products", products);
        request.setAttribute("categories",categories);
        request.setAttribute("brands",brands);
        request.getRequestDispatcher("admin/products.jsp").forward(request,response);
    }

//    private void blockedAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Users users = iUsersService.findById(id);
////        users.setStatus(Status.BLOCKED);
//        boolean check = iUsersService.update(id,users);
//        request.setAttribute("checkBlock",check);
//        getAllUsers(request,response);
//    }
//
//    private void activeAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Users users = iUsersService.findById(id);
////        users.setStatus(Status.ACTIVE);
//        boolean check = iUsersService.update(id,users);
//        request.setAttribute("checkActive",check);
//        getAllUsers(request,response);
//    }
//
//
//    private void getAllTablets(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Book> tablets = IBookService.findByKeyword("tablet");
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
//
//    private void getAllCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Users> users = iUsersService.getAll();
//        List<Users> customers = new ArrayList<>();
//        for (int i = 0; i < users.size(); i++) {
//            if (users.get(i).getRole() == Role.USER){
//                customers.add(users.get(i));
//            }
//        }
//        request.setAttribute("users", customers);
//        request.getRequestDispatcher("admin/users.jsp").forward(request,response);
//    }
//
//    private void getAllAdmins(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Users> users = iUsersService.getAll();
//        List<Users> admins = new ArrayList<>();
//        for (int i = 0; i < users.size(); i++) {
//            if (users.get(i).getRole() == Role.ADMIN){
//                admins.add(users.get(i));
//            }
//        }
//        request.setAttribute("users", admins);
//        request.getRequestDispatcher("admin/users.jsp").forward(request,response);
//    }
//
//    private void getAllUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Users> users = iUsersService.getAll();
//        request.setAttribute("users", users);
//        request.getRequestDispatcher("admin/users.jsp").forward(request,response);
//    }
//
//    private void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Users> users = iUsersService.getAll();
//        List<Product> products = iProductService.getAll();
//        request.setAttribute("users", users);
//        request.setAttribute("products", products);
//        request.getRequestDispatcher("admin/system.jsp").forward(request,response);
//
//    }
//
//
//    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        boolean checkDelete = iProductService.delete(id);
//        List<Product> products = iProductService.getAll();
//        request.setAttribute("products", products);
//        request.setAttribute("checkDel", checkDelete);
//        request.setAttribute("categories",categories);
//        request.setAttribute("brands",brands);
//        request.getRequestDispatcher("admin/products.jsp").forward(request,response);
//    }
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
//    private void editBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String serial = request.getParameter("serial");
//        String name = request.getParameter("name");
//        int categoryId = Integer.parseInt(request.getParameter("category"));
//        int brandId = Integer.parseInt(request.getParameter("brand"));
//        double price = Double.parseDouble(request.getParameter("price"));
//        int quantity = Integer.parseInt(request.getParameter("quantity"));
//        String description = request.getParameter("description");
//        String imageURL = request.getParameter("imageURL");
//        Product product = new Product(serial,name,price,quantity,description,imageURL);
//        int id = Integer.parseInt(request.getParameter("id"));
//        boolean check = iProductService.update(id , product, categoryId, brandId);
//        request.setAttribute("checkEdit", check);
//        List<Product> products = iProductService.getAll();
//        request.setAttribute("categories",categories);
//        request.setAttribute("brands",brands);
//        request.setAttribute("products", products);
//        request.getRequestDispatcher("admin/products.jsp").forward(request,response);
//    }
//

}

