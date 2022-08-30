package com.example.casestudymodule3.dao.interfaceDao;

import com.example.casestudymodule3.dao.IGeneralDAO;
import com.example.casestudymodule3.model.Review;

import java.util.List;

public interface IReviewDao extends IGeneralDAO<Review> {
    @Override
    default boolean add(Review review){
        return false;
    };
    boolean add(Review review, int userId, int bookId);
    List<Review> findListReviewById(int bookId);
}
