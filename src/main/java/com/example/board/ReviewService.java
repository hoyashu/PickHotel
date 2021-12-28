package com.example.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("reviewService")
@Transactional
public class ReviewService {
    @Autowired
    private ReviewDao reviewDao;

    public void registerReview(ReviewVo review){
        this.reviewDao.insertReview(review);
    }

    public void modifyReview(ReviewVo review){
        this.reviewDao.updateReview(review);
    }

    public void removeReview(int postNo){
        this.reviewDao.deleteReview(postNo);
    }

    public ReviewVo retrieveReview(int postNo){
        return this.reviewDao.selectReview(postNo);
    }
}
