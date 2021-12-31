package com.example.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("attachService")
public class AttachService {
    @Autowired
    private AttachDao attachDao;

    //파일을 등록하다.
    public void registerAttach(AttachVo attach) {
        this.attachDao.insertPostAttach(attach);
    }

    //파일을 삭제하다.
    public void removePostAttach(int attNo) {
        this.attachDao.deletePostAttach(attNo);
    }

    //게시글에 의한 파일삭제
    public void removeAttachByPost(int poNo) {
        this.attachDao.deleteAttachbyPost(poNo);
    }

    // 파일을 조회하다.
    public List<AttachVo> retrievePostAttach(int poNo) {
        return this.attachDao.selectPostAttach(poNo);
    }

}