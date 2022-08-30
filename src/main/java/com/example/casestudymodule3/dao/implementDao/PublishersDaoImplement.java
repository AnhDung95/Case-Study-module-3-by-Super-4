package com.example.casestudymodule3.dao.implementDao;

import com.example.casestudymodule3.dao.interfaceDao.IPublishersDao;
import com.example.casestudymodule3.model.Publishers;
import com.example.casestudymodule3.connection.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PublishersDaoImplement implements IPublishersDao {
    public static final String QUERY_ALL_PUBLISHERS = "SELECT*FROM publishers";
    public static final String QUERY_ADD_PUBLISHERS = "INSERT INTO publishers (name) VALUE (?);";
    public static final String QUERY_UPDATE_PUBLISHERS ="UPDATE publishers SET name = ? WHERE (id = ?);";
    public static final String QUERY_DELETE_PUBLISHERS ="DELETE FROM publishers WHERE (id = ?);";
    public static final String QUERY_FIND_PUBLISHERS_BY_ID ="SELECT publishers.name FROM publishers WHERE id = ? ;";
    private final Connection connection = ConnectionDB.getConnection();

    @Override
    public List<Publishers> getAll() {
        List<Publishers> publishers = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_ALL_PUBLISHERS);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                publishers.add(new Publishers(id,name));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return publishers;
    }

    @Override
    public boolean add(Publishers publishers) {
        boolean rowAdded = false;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_ADD_PUBLISHERS);
            statement.setString(1, publishers.getName());
            rowAdded= statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowAdded;
    }

    @Override
    public boolean update(int id, Publishers publishers) {
        boolean rowUpdate = false;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_UPDATE_PUBLISHERS);
            statement.setString(1, publishers.getName());
            statement.setInt(2,publishers.getId());
            rowUpdate = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowUpdate;
    }

    @Override
    public boolean delete(int id) {
        boolean rowDeleted = false;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_DELETE_PUBLISHERS);
            statement.setInt(1,id);
            rowDeleted = statement.executeUpdate() >0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDeleted;
    }

    @Override
    public Publishers findById(int id) {
        Publishers publishers = null;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_FIND_PUBLISHERS_BY_ID);
        }
        return null;
    }
}
