package com.example.board.persistent;

import com.example.board.model.ReviewVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("reviewDao")
public class ReviewDao {
    @Autowired
    private SqlSession sqlSession;

    // 리뷰를 등록하다.
    public void insertReview(ReviewVo review) {
        this.sqlSession.insert("ReviewDao.insertReview", review);
    }

    //리뷰를 조회하다.
    public ReviewVo selectReview(int postNo) {
        return this.sqlSession.selectOne("ReviewDao.selectReview", postNo);
    }

    //숙소 리뷰 갯수를 조회하다.
    public int selectReviewCountByRoom(int roomNo) {
        return this.sqlSession.selectOne("ReviewDao.selectReviewCountByRoom", roomNo);
    }

    //숙소 리뷰 평점를 조회하다.
    public float selectReviewRateByRoom(int roomNo) {
        return this.sqlSession.selectOne("ReviewDao.selectReviewRateByRoom", roomNo);
    }

    // 리뷰를 업데이트하다.
    public void updateReview(ReviewVo review) {
        this.sqlSession.update("ReviewDao.updateReview", review);
    }

    //리뷰를 삭제한다.
    public void deleteReview(int postNo) {
        this.sqlSession.delete("ReviewDao.deleteReview", postNo);
    }


}













