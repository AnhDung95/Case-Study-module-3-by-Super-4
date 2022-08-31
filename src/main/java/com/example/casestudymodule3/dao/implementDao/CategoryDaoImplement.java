package com.example.casestudymodule3.dao.implementDao;

import com.example.casestudymodule3.connection.ConnectionDB;
import com.example.casestudymodule3.dao.interfaceDao.ICategoryDao;
import com.example.casestudymodule3.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImplement implements ICategoryDao {
    private final Connection connection = ConnectionDB.getConnection();
    private static final String QUERY_ALL_CATEGORY = "SELECT * FROM category";
    private static final String QUERY_INSERT_CATEGORY = "INSERT INTO `bookcase`.`category` (`NAME`) VALUES (?);";
    private static final String QUERY_UPDATE_CATEGORY = "UPDATE `bookcase`.`category` SET `NAME` = ? " + "WHERE `ID` = ?";
    private static final String QUERY_DELETE_CATEGORY = "DELETE FROM `bookcase`.`category` WHERE `ID` = ?;";
    private static final String QUERY_FIND_CATEGORY_BY_ID = "SELECT category.name FROM category WHERE ID = ?";

    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_ALL_CATEGORY);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                categories.add(new Category(id,name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }

    @Override
    public boolean add(Category category) {
        boolean rowAdded = false;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_DELETE_CATEGORY);
            statement.setString(1, category.getName());
            rowAdded = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowAdded;
    }

    @Override
    public boolean update(int id, Category category) {
        boolean rowUpdate = false;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_UPDATE_CATEGORY);
            statement.setString(1, category.getName());
            statement.setInt(2,id);
            rowUpdate = statement.executeUpdate() > 0;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public boolean delete(int id) {
        boolean rowDelete = false;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_DELETE_CATEGORY);
            statement.setInt(1,id);
            rowDelete=statement.executeUpdate()>0;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDelete;
    }

    @Override
    public Category findById(int id) {
        Category category = null;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_FIND_CATEGORY_BY_ID);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                String name = rs.getString(1);
                category = new Category(id, name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return category;
    }
}
