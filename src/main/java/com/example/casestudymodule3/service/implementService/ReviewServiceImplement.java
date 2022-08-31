package com.example.casestudymodule3.service.implementService;

import com.example.casestudymodule3.dao.implementDao.ReviewDaoImplement;
import com.example.casestudymodule3.dao.interfaceDao.IReviewDao;
import com.example.casestudymodule3.model.Review;
import com.example.casestudymodule3.service.interfaceService.IReviewService;

import java.util.List;

public class ReviewServiceImplement implements IReviewService {
    private final IReviewDao reviewDao = new ReviewDaoImplement();

    @Override
    public List<Review> getAll() {
        return reviewDao.getAll();
    }

    @Override
    public boolean add(Review review) {
        return false;
    }

    @Override
    public boolean update(int id, Review review) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return reviewDao.delete(id);
    }

    @Override
    public Review findById(int id) {
        return null;
    }

    @Override
    public List<Review> findListReviewById(int bookId) {
        return reviewDao.findListReviewById(bookId);
    }

    @Override
    public boolean add(Review review, int userId, int bookId) {
        return reviewDao.add(review,userId,bookId);
    }
}
