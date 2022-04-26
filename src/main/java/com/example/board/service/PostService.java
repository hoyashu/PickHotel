package com.example.board.service;

import com.example.board.model.PostSummaryVo;
import com.example.board.model.PostVo;
import com.example.board.persistent.AttachDao;
import com.example.board.persistent.BoardDao;
import com.example.board.persistent.PostDao;
import com.example.board.persistent.ReviewDao;
import com.example.common.paging.PaginationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("postService")
public class PostService {
    @Autowired
    private PostDao postDao;

    @Autowired
    private ReviewDao reviewDao;

    @Autowired
    private AttachDao attachDao;

    @Autowired
    private BoardDao boardDao;

    // 게시글 정보를 등록하다.
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {RuntimeException.class})
    public int addPost(PostVo post) {
        int no = this.postDao.insertPost(post);
        return no;
    }

    //전체 게시글 태그 검색
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true, rollbackFor = {RuntimeException.class})
    public List<PostSummaryVo> findPostListByTag(String tag) {
        List<PostSummaryVo> posts = this.postDao.selectPostByTag(tag);
        return posts;
    }

    // 게시글 상세정보 조회
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true, rollbackFor = {RuntimeException.class})
    public PostVo findPostByNo(int postNo) {
        return this.postDao.selectDetailPost(postNo);
    }

    // 게시글 존재 여부 조회
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true, rollbackFor = {RuntimeException.class})
    public Integer findPostCountByExisetence(PostVo post) {
        return this.postDao.selectPostSearch(post);
    }

    //회원별 게시글 목록 조회
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true, rollbackFor = {RuntimeException.class})
    public List<PostSummaryVo> findPostListByMemNo(int MemNo) {
        List<PostSummaryVo> posts = this.postDao.selectMyPosts(MemNo);
        if (posts.size() == 0) {
            posts = null;
        }
        return posts;
    }

    // 특정 게시판 내 게시글 정보 전체 조회 (유닛테스트 - 게시글 작성을 위함)
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true, rollbackFor = {RuntimeException.class})
    public List<PostVo> findPostListByBoard(int boardNo) {
        return this.postDao.selectPostListByBoard(boardNo);
    }

    // 뷰에 출력될 게시글 목록 조회
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true, rollbackFor = {RuntimeException.class})
    public List<PostSummaryVo> findPostList(PostSummaryVo params) {
        List<PostSummaryVo> postList = new ArrayList<PostSummaryVo>();

        int postCount = this.postDao.selectPostCount(params);
        PaginationInfo paginationInfo = new PaginationInfo(params);
        paginationInfo.setTotalRecordCount(postCount);

        params.setPaginationInfo(paginationInfo);

        if (postCount > 0) {
            postList = this.postDao.selectPostList(params);
        }

        return postList;
    }

    // 게시글 조회수 증가
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {RuntimeException.class})
    public void upHitcount(int postNo) {
        this.postDao.upHitcount(postNo);
    }

    //게시글 정보를 변경하다.
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {RuntimeException.class})
    public void modifyPost(PostVo post) {
        this.postDao.updatePost(post);
    }

    //게시글 조회
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {RuntimeException.class})
    public void removePost(int postNo, int boardNo) {
        attachDao.deleteAttachbyPost(postNo);
        reviewDao.deleteReview(postNo);
        postDao.deletePost(postNo);
        this.boardDao.updateBoardPost(boardNo, -1);
    }
}






















