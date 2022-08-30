package com.example.casestudymodule3.service.interfaceService;

import com.example.casestudymodule3.model.Review;
import com.example.casestudymodule3.service.IGeneralService;

import java.util.List;

public interface IReviewService extends IGeneralService<Review> {
    List<Review> findListReviewById(int bookId);
    boolean add(Review review,int userId, int bookId);
}
