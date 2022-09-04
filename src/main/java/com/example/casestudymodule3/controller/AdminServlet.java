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

@WebServlet(name = "AdminServlet", urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
    private final IUsersService iUsersService = new UsersServiceImplement();
    private final IBookService iBookService = new BookServiceImplement();
    private final List<Users> users=iUsersService.getAll();
//    private final ICategoryService categoryService = new CategoryServiceImplement();
//    private final List<Category> categories = categoryService.getAll();
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
                break;
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

}
