package com.example.board.service;

import com.example.board.model.AttachVo;
import com.example.board.persistent.AttachDao;
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

    //게시글 삭제에 의해 파일을 삭제한다.
    public void removeAttachByPost(int poNo) {
        this.attachDao.deleteAttachbyPost(poNo);
    }

    //게시글 번호로 파일목록을 조회한다.
    public List<AttachVo> retrievePostAttach(int poNo) {
        return this.attachDao.selectPostAttach(poNo);
    }

    //파일을 조회한다.
    public AttachVo retrievePostAttachByAtNo(int attaNo) {
        return this.attachDao.selectPostAttachByAtNo(attaNo);
    }
}