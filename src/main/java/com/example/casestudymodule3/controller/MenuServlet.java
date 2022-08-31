package com.example.casestudymodule3.controller;

import com.example.casestudymodule3.dao.interfaceDao.ICategoryDao;
import com.example.casestudymodule3.model.Category;
import com.example.casestudymodule3.service.implementService.CategoryServiceImplement;
import com.example.casestudymodule3.service.interfaceService.ICategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MenuServlet", urlPatterns = "/books")
public class MenuServlet extends HttpServlet {
    private final ICategoryService iCategoryService = new CategoryServiceImplement();
    private final List<Category> categorie = iCategoryService.getAll();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

private void action(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String action = req.getParameter("action");
    if(action == null) {
    action = "";
    }
    switch (action) {
        case "addCategory":
            addCategory(req,resp);
            break;
        case "editCategory":
            editCategory(req,resp);
            break;
        case "deleteCategory":
            deleteCategory(req,resp);
            break;
        default:
            display(req,resp);
    }
    }

    private void addCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        Category category = new Category(id, name);
        iCategoryService.add(category);
        req.setAttribute("iCategoryService",iCategoryService);
        req.getRequestDispatcher("category/add.jsp").forward(req,resp);
    }

    private void editCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private void deleteCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int id= Integer.parseInt(req.getParameter("id"));
    boolean checkDelete = iCategoryService.delete(id);
    List<Category> categories = iCategoryService.getAll();
    req.setAttribute("categories", categories);
    req.setAttribute("checkDelete", checkDelete);
    req.setAttribute("category",categorie);
    req.getRequestDispatcher("category/delete.jsp").forward(req,resp);


    }

    private void display(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    List<Category> categories = this.iCategoryService.getAll();
    req.setAttribute("dskh", categories);
    req.getRequestDispatcher("/category/all.jsp").forward(req,resp);
    }
}
