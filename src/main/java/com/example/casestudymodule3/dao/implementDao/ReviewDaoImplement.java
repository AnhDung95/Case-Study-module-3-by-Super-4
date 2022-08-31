package com.example.casestudymodule3.dao.implementDao;

import com.example.casestudymodule3.connection.ConnectionDB;
import com.example.casestudymodule3.dao.interfaceDao.IReviewDao;
import com.example.casestudymodule3.model.Review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewDaoImplement implements IReviewDao {
    private final Connection connection = ConnectionDB.getConnection();
    private static final String QUERY_ALL_REVIEWS = "SELECT book.ID , users.ACCOUNT, review.COMMENT" +
            "FROM ((review JOIN book ON review.book_id = book.id) JOIN users ON users.id = review.user_id);";
    private static final String QUERY_INSERT_REVIEW = "INSERT INTO review (`BOOK_ID`, `USER_ID`, `COMMENT`) " + "VALUES (?,?,?);";
    private static final String QUERY_DELETE_REVIEW = "DELETE FROM review WHERE (`ID` = ?);";
    private static final String QUERY_FIND_REVIEW_BOOK_BY_ID = "SELECT users.ACCOUNT, review.COMMENT " +
            "FROM review JOIN book ON review.book_id = book.id JOIN users ON users.id = review.user_id " +
            "WHERE book.id = ?;";

    @Override
    public List<Review> getAll() {
        List <Review> reviews = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_ALL_REVIEWS);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);
                String account = rs.getString(2);
                String comment = rs.getString(3);
                reviews.add(new Review(id,account,comment));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return reviews;
    }

    @Override
    public boolean update(int id, Review review) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        boolean rowDelete = false;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_DELETE_REVIEW);
            statement.setInt(1, id);
            rowDelete = statement.executeUpdate() >0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDelete;
    }

    @Override
    public Review findById(int id) {
        return null;
    }

    @Override
    public boolean add(Review review, int userId, int bookId) {
        boolean rowAdded = false;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_INSERT_REVIEW);
            statement.setInt(1,bookId);
            statement.setInt(2,userId);
            statement.setString(3,review.getComment());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowAdded;
    }

    @Override
    public List<Review> findListReviewById(int bookId) {
        List<Review> reviews = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_FIND_REVIEW_BOOK_BY_ID);
            statement.setInt(1,bookId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                String userAccount = rs.getString(1);
                String comment = rs.getString(2);
                reviews.add(new Review(bookId,userAccount,comment));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return reviews;
    }
}
