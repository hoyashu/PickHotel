package com.example.board.service;

import com.example.board.model.ReviewVo;
import com.example.board.persistent.ReviewDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("reviewService")
public class ReviewService {
    @Autowired
    private ReviewDao reviewDao;

    public void registerReview(ReviewVo review) throws Exception {
        this.reviewDao.insertReview(review);
    }

    public void modifyReview(ReviewVo review) throws Exception {
        this.reviewDao.updateReview(review);
    }

    public void removeReview(int postNo) throws Exception {
        this.reviewDao.deleteReview(postNo);
    }

    public ReviewVo retrieveReview(int postNo) throws Exception {
        return this.reviewDao.selectReview(postNo);
    }
}
