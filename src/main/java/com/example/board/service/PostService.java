package com.example.board.service;

import com.example.board.model.BoardVo;
import com.example.board.model.PostVo;
import com.example.board.persistent.AttachDao;
import com.example.board.persistent.PostDao;
import com.example.board.persistent.ReviewDao;
import com.example.common.paging.PaginationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("postService")
public class PostService {
    @Autowired
    private PostDao postDao;

    @Autowired
    private ReviewDao reviewDao;

    @Autowired
    private AttachDao attachDao;

    // 게시글 정보를 등록하다.
    public int registerPost(PostVo post) {
        int no = this.postDao.insertPost(post);
        return no;
    }

    //게시글 전체 조회
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true, rollbackFor = {RuntimeException.class})
    public List<PostVo> retrieveAllPosts(int boardNo) {
        List<PostVo> posts = this.postDao.selectAllPosts(boardNo);
        if (posts.size() == 0) {
            posts = null;
        }
        return posts;
    }

    public List<Integer> retrieveBoardNo() {
        return this.postDao.selectBoardNo();
    }

    public List<String> retrieveBoardName() {
        return this.postDao.selectBoardName();
    }

    // 게시글 상세정보 조회
    public PostVo retrieveDetailBoard(int postNo) {
        return this.postDao.selectDetailPost(postNo);
    }

    //회원별 게시글 목록 조회
    public List<PostVo> retrieveMyPosts(int MemNo) {
        List<PostVo> posts = this.postDao.selectMyPosts(MemNo);
        if (posts.size() == 0) {
            posts = null;
        }
        return posts;
    }

    public List<PostVo> retrievePostList(PostVo params){
        List<PostVo> postList = new ArrayList<PostVo>();

        int postCount = this.postDao.selectPostCount(params);
        PaginationInfo paginationInfo = new PaginationInfo(params);
        paginationInfo.setTotalRecordCount(postCount);

        params.setPaginationInfo(paginationInfo);

        if (postCount > 0) {
            postList = this.postDao.selectPostList(params);
        }

        return postList;
    }

    public int retrievePostCount(PostVo params){
        return this.postDao.selectPostCount(params);
    }


    // 게시글 조회수 증가
    public void upHitcount(int postNo) {
        this.postDao.upHitcount(postNo);
    }

    // 모든 게시판 조회 번호와 이름만
    public List<BoardVo> retrieveAllBoards(){
       return this.postDao.selectAllBoards();
    }

    public BoardVo retrieveBoardForUseCheck(int boardNo) {
        return this.postDao.selectBoardForUseCheck(boardNo);
    }


    //게시글 정보를 변경하다.
    public void modifyPost(PostVo post) {
        this.postDao.updatePost(post);
    }

    public void removePostAttach(int attachNo) {
        attachDao.deletePostAttach(attachNo);
    }

    public void removePost(int postNo) {
        attachDao.deleteAttachbyPost(postNo);
        reviewDao.deleteReview(postNo);
        postDao.deletePost(postNo);
    }
}






















