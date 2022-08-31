package com.example.casestudymodule3.controller;

import com.example.casestudymodule3.dao.implementDao.RentalBillDaoImplement;
import com.example.casestudymodule3.model.*;
import com.example.casestudymodule3.service.implementService.BookServiceImplement;
import com.example.casestudymodule3.service.implementService.PublishersServiceImplement;
import com.example.casestudymodule3.service.implementService.RentalServiceImplement;
import com.example.casestudymodule3.service.interfaceService.IBookService;
import com.example.casestudymodule3.service.interfaceService.IRentalService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet(name = "CartServlet", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {
    private final IBookService iBookService = new BookServiceImplement();
    private final List<Publishers> publishers = new PublishersServiceImplement().getAll();
    private final IRentalService iRentalService = new RentalServiceImplement();
    private final RentalBillDaoImplement rentalBillDaoImplement = new RentalBillDaoImplement();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        action(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        action(req,resp);
    }

    private void action(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        String action = req.getParameter("action");
        if (action==null)
            action = "";
        switch (action) {
            case "add" :
                addToCart(req,resp);
                break;
            case "remove" :
                removeBook(req,resp);
                break;
            case "checkout":
                checkoutCart(req,resp);
                break;
            case "payment" :
                payment(req,resp);
                break;
            default:
                displayCart(req,resp);
        }
    }

    private void displayCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<Item> cart;
        if(session.getAttribute("cart") == null){
            cart = new ArrayList<>();
        } else {
            cart = (List<Item>) session.getAttribute("cart");
        }
        int subtotal = 0;
        for (Item item:cart) {
            subtotal += item.getBook().getQuantity() * item.getQuantity();
        }
        session.setAttribute("subtotal", subtotal);
        session.setAttribute("cart",cart);
        req.setAttribute("publishers",publishers);
        req.getRequestDispatcher("/client/view/cart.jsp").forward(req,resp);
    }

    private void addToCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        HttpSession session = req.getSession();
        int id = Integer.parseInt(req.getParameter("id"));
        int quantity = 1;
        Book book = iBookService.findById(id);
        List<Item> cart;
        if(req.getParameter("quantity") != null){
            quantity = Integer.parseInt(req.getParameter("quantity"));
        }
        if(session.getAttribute("cart") == null){
            cart = new ArrayList<>();
            cart.add(new Item(book,quantity));
        } else {
            cart = (List<Item>) session.getAttribute("cart");
            boolean check = false;
            for (Item item:cart) {
                if(item.getBook().getId() == book.getId()){
                    item.setQuantity(item.getQuantity() + quantity);
                    check = true;
                }
            }
            if(check == false){
                cart.add(new Item(book,quantity));
            }
        }
        int subtotal = 0;
        for (Item item:cart) {
            subtotal += item.getBook().getQuantity() * item.getQuantity();
        }
        session.setAttribute("subtotal", subtotal);
        session.setAttribute("cart",cart);
        req.setAttribute("publishers",publishers);
        req.getRequestDispatcher("/client/view/cart.jsp").forward(req,resp);
    }

    private void removeBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        HttpSession session = req.getSession();
        int id = Integer.parseInt(req.getParameter("id"));
        Book book = iBookService.findById(id);
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        cart.removeIf(item -> item.getBook().getId() == book.getId());
        int subtotal = 0;
        for (Item item:cart) {
            subtotal += item.getBook().getQuantity() * item.getQuantity();
        }
        session.setAttribute("subtotal", subtotal);
        session.setAttribute("cart",cart);
        req.setAttribute("publishers",publishers);
        req.getRequestDispatcher("/client/view/cart.jsp").forward(req,resp);
    }

    private void checkoutCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        HttpSession session = req.getSession();
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        session.setAttribute("cart",cart);
        req.setAttribute("publishers",publishers);
        req.getRequestDispatcher("/client/view/checkout.jsp").forward(req,resp);

    }

    private void payment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int userID = (int) session.getAttribute("userID");
        String address = req.getParameter("address");
        String phone = req.getParameter("tel");
        boolean checkRental = iRentalService.add(new Rental(userID,address,phone),userID);
        Rental rental = iRentalService.findById(userID);
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        for (Item item:cart) {
            RentalBill rentalBill = new RentalBill(rental.getId(),item.getBook().getId(),item.getQuantity(),(item.getQuantity() * item.getBook().getQuantity()));
            rentalBillDaoImplement.add(rentalBill);
            iBookService.reduce(item.getQuantity(),item.getBook().getId());
        }
        session.removeAttribute("cart");
        req.setAttribute("checkOrder",checkRental);
        req.getRequestDispatcher("/client/view/checkout.jsp").forward(req,resp);

    }
}
