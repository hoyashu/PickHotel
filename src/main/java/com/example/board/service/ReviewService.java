package com.example.board.service;

import com.example.board.model.ReviewVo;
import com.example.board.persistent.ReviewDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("reviewService")
public class ReviewService {
    @Autowired
    private ReviewDao reviewDao;

    //리뷰 등록
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {RuntimeException.class})
    public void registerReview(ReviewVo review) {
        this.reviewDao.insertReview(review);
    }

    //리뷰 상세조회
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true, rollbackFor = {RuntimeException.class})
    public ReviewVo retrieveReview(int postNo) {
        return this.reviewDao.selectReview(postNo);
    }

    //숙소 리뷰 갯수 조회
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true, rollbackFor = {RuntimeException.class})
    public int retrieveReviewCountByRoom(int roomNo) {
        return this.reviewDao.selectReviewCountByRoom(roomNo);
    }

    //숙소 리뷰 평점 조회
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true, rollbackFor = {RuntimeException.class})
    public float retrieveReviewRateByRoom(int roomNo) {
        return this.reviewDao.selectReviewRateByRoom(roomNo);
    }

    //리뷰 수정
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {RuntimeException.class})
    public void modifyReview(ReviewVo review) {
        this.reviewDao.updateReview(review);
    }

    //리뷰 삭제
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {RuntimeException.class})
    public void removeReview(int postNo) {
        this.reviewDao.deleteReview(postNo);
    }

}
