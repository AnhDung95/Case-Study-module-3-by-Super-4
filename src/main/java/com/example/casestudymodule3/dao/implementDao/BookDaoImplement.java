package com.example.casestudymodule3.dao.implementDao;

import com.example.casestudymodule3.connection.ConnectionDB;
import com.example.casestudymodule3.dao.interfaceDao.IBookDao;
import com.example.casestudymodule3.model.Book;
import com.example.casestudymodule3.model.Status;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImplement implements IBookDao {
    private final Connection connection = ConnectionDB.getConnection();
    private static final String QUERY_ALL_BOOK =
            "SELECT book.id,book.name,book.`describe`,book.author,category.name,publishers.name,book.quantity,book.img " +
                    "FROM book JOIN category ON book.category_id = category.id JOIN publishers ON book.publishers_id = publishers.id " +
                    "WHERE book.status = \"NEW\";";
    private static final String QUERY_INSERT_BOOK =
            "INSERT INTO book" +
                    "(name,`describe`,author,category_Id,publishers_Id,quantity,img)" +
                    "VALUES (?,?,?,?,?,?,?)";
    private static final String QUERY_FIND_BY_ID =
            "SELECT book.name,book.`describe`,book.author,category.name,publishers.name,book.quantity,book.img,book.create,book.status " +
                    "FROM book JOIN category ON book.category_id = category.id JOIN publishers ON book.publishers_id = publishers.id " +
                    "WHERE book.id = ?;";

    private static final String QUERY_DEL_BOOK = "UPDATE book SET STATUS = \"old\" WHERE id = ?";
    private static final String QUERY_UPDATE_BOOK = "UPDATE BOOK SET NAME = ?,`DESCRIBE` = ?,AUTHOR = ?, CATEGORY_ID = ?,PUBLISHERS_ID = ?,QUANTITY = ?,IMG = ? WHERE ID = ?;";
    private static final String QUERY_FIND_BY_KEYWORD = "SELECT book.id,book.name,book.`describe`,book.author,category.name,publishers.name,book.quantity,book.img FROM book JOIN category ON book.category_id = category.id JOIN publishers ON book.publishers_id = publishers.id WHERE (category.name LIKE ? or book.name LIKE ? or publishers.name LIKE ?) AND book.STATUS = \"new\";";
    private static final String QUERY_FILTER_BY_PUBLISHERS = "SELECT product.id,product.serial,product.name,category.name,brand.name,product.price,product.quantity,product.description,product.image\n" +
            "FROM book JOIN category ON book.category_id = category.id JOIN publishers ON book.publishers_id = publishers.id WHERE category.NAME LIKE ? and publishers.NAME LIKE ? AND book.status = \"New\";";
    private static final String QUERY_REDUCE_BOOK = "UPDATE book SET QUANTITY = ? WHERE ID = ?";
    @Override
    public List<Book> findByKeyWord(String keyword) {
        List<Book> books = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_FIND_BY_KEYWORD);
            statement.setString(1,"%" + keyword + "%");
            statement.setString(2,"%" + keyword + "%");
            statement.setString(3,"%" + keyword + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String describe = rs.getString(3);
                String author = rs.getString(4);
                String category = rs.getString(5);
                String publishers = rs.getString(6);
                int quantity = rs.getInt(7);
                String imgURL = rs.getString(8);
                books.add(new Book(id,name,describe,author,category,publishers,quantity,imgURL));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    @Override
    public boolean add(Book book, int idCategory, int idPublishers) {
        boolean rowAdd = false;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_INSERT_BOOK);
            statement.setString(1, book.getName());
            statement.setString(2, book.getDescribe());
            statement.setString(3, book.getAuthor());
            statement.setInt(4,idCategory);
            statement.setInt(5,idPublishers);
            statement.setInt(6,book.getQuantity());
            statement.setString(7, book.getImg());
            rowAdd = statement.executeUpdate() > 0;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return rowAdd;
    }

    @Override
    public boolean update(int id, Book book, int categoryId, int publishersId) {
        boolean rowUpdate = false;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_UPDATE_BOOK);
            statement.setString(1,book.getName());
            statement.setString(2, book.getDescribe());
            statement.setString(3, book.getAuthor());
            statement.setInt(4,categoryId);
            statement.setInt(5,publishersId);
            statement.setInt(6,book.getQuantity());
            statement.setString(7,book.getImg());
            statement.setInt(8, id);
            System.out.println(statement);
//            UPDATE BOOK SET NAME = ?,DESCRIBE = ?,AUTHOR = ?, CATEGORY_ID = ?,PUBLISHERS_ID = ?,QUANTITY = ?,IMG = ? WHERE ID = ?;
            rowUpdate = statement.executeUpdate() > 0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public List<Book> filter(String categoryName, String publishersName) {
        return null;
    }

    @Override
    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_ALL_BOOK);
            System.out.println(statement);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String describe = rs.getString(3);
                String author = rs.getString(4);
                String category = rs.getString(5);
                String publishers = rs.getString(6);
                int quantity = rs.getInt(7);
                String imgURL = rs.getString(8);
                books.add(new Book(id,name,describe,author,category,publishers,quantity,imgURL));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    @Override
    public boolean delete(int id) {
        boolean rowDelete = false;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_DEL_BOOK);
            statement.setInt(1,id);
            rowDelete = statement.executeUpdate() > 0;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }

    @Override
    public Book findById(int id) {
        Book book = null;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_FIND_BY_ID);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                String name = rs.getString(1);
                String describe = rs.getString(2);
                String author = rs.getString(3);
                String category = rs.getString(4);
                String publishers = rs.getString(5);
                int quantity = rs.getInt(6);
                String imgURL = rs.getString(7);
                Timestamp create = Timestamp.valueOf(rs.getString(8));
                Status status = Status.valueOf(rs.getString(9));
                book = new Book(id,name,describe,author,category,publishers,quantity, create, status, imgURL);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return book;
    }

    @Override
    public boolean reduce(int quantity, int idBook) {
        boolean rowReduce = false;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_REDUCE_BOOK);
            statement.setInt(1,quantity);
            statement.setInt(2,idBook);
            rowReduce = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowReduce;
    }
}
