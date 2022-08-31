package com.example.casestudymodule3.dao.implementDao;

import com.example.casestudymodule3.connection.ConnectionDB;
import com.example.casestudymodule3.dao.interfaceDao.IRentalDao;
import com.example.casestudymodule3.model.Rental;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RentalDaoImplement implements IRentalDao {
    private final Connection connection = ConnectionDB.getConnection();
    private static final String QUERY_ALL_RENTAL = "SELECT r.id,users.ACCOUNT,r.CREATE,r.DELIVERY,r.STATUS,r.ADDRESS,r.PHONE " +
            "FROM rental r JOIN users on users.id = r.USER_ID WHERE users.role = \"USER\";";
    private static final String QUERY_INSERT_RENTAL_BY_USER = "INSERT INTO rental (USER_ID,ADDRESS,PHONE) VALUES (?,?,?)";
    private static final String QUERY_UPDATE_RENTAL_BY_ADMIN = "UPDATE rental SET DELIVERY = ?, STATUS = ? WHERE ID = ?";
    private static final String QUERY_DEL_RENTAL = "DELETE FROM rental WHERE ID = ?";
    private static final String QUERY_FIND_RENTAL_BY_ID = "SELECT r.ID,r.USER_ID,r.STATUS,r.ADDRESS,r.PHONE " +
            "FROM rental r JOIN users on users.id = r.USER_ID WHERE users.id  = ?";

    @Override
    public List<Rental> getAll() {
        List<Rental> publishers = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_ALL_RENTAL);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                int idUserAccount = rs.getInt(2);
                LocalDate createDay = LocalDate.parse(String.valueOf(rs.getDate(3)), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                LocalDate deliveryDay = LocalDate.parse(String.valueOf(rs.getDate(4)), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                String status = rs.getString(5);
                String address = rs.getString(6);
                String phone = rs.getString(7);
                publishers.add(new Rental(id,idUserAccount,createDay,deliveryDay,status,address,phone));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return publishers;
    }

    @Override
    public boolean update(int id, Rental rental) {
        boolean rowUpdate = false;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_UPDATE_RENTAL_BY_ADMIN);
            statement.setString(1,String.valueOf(rental.getDuration()));
            statement.setString(2,rental.getStatus());
            statement.setInt(3,id);
            rowUpdate = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return rowUpdate;
    }

    @Override
    public boolean delete(int id) {
        boolean rowDelete = false;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_DEL_RENTAL);
            statement.setInt(1,id);
            rowDelete = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDelete;
    }

    @Override
    public Rental findById(int id) {
        Rental rental = null;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_FIND_RENTAL_BY_ID);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int rentalId = rs.getInt(1);
                int idAccount = rs.getInt(2);
                String status = rs.getString(3);
                String address = rs.getString(4);
                String phone = rs.getString(5);
                rental = new Rental(rentalId,idAccount,status,address,phone);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rental;
    }

    @Override
    public boolean add(Rental rental, int idUser) {
        boolean rowAdd = false;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_INSERT_RENTAL_BY_USER);
            statement.setInt(1,idUser);
            statement.setString(2,rental.getAddress());
            statement.setString(3,rental.getPhone());
            rowAdd = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowAdd;
    }
}
