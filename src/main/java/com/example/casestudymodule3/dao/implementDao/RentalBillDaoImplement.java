package com.example.casestudymodule3.dao.implementDao;

import com.example.casestudymodule3.connection.ConnectionDB;
import com.example.casestudymodule3.dao.interfaceDao.IRentalBillDao;
import com.example.casestudymodule3.model.RentalBill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class RentalBillDaoImplement implements IRentalBillDao {
    private final Connection connection = ConnectionDB.getConnection();
    private static final String QUERY_INSERT_RENTAL_BILL = "INSERT INTO rental_bill (bill_Id,book_Id,quantity,total) VALUES(?,?,?,?)";
    private static final String QUERY_DEL_RENTAL_BILL = "DELETE FROM rental_bill WHERE book_Id = ? AND bill_Id = ?";
    private static final String QUERY_GET_LIST_RENTAL_BY_ID = "SELECT * FROM ";

    @Override
    public List<RentalBill> getAll() {
        return null;
    }

    @Override
    public boolean add(RentalBill rentalBill) {
        boolean rowAdd = false;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_INSERT_RENTAL_BILL);
            statement.setInt(1,rentalBill.getOrderId());
            statement.setInt(2,rentalBill.getBookId());
            statement.setInt(3,rentalBill.getQuantity());
            statement.setDouble(4,rentalBill.getTotal());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowAdd;
    }

    @Override
    public boolean update(int id, RentalBill rentalBill) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public RentalBill findById(int id) {
        return null;
    }

    @Override
    public List<RentalBill> getRentalBillByIdRental(int idRetal) {
        return null;
    }
}
