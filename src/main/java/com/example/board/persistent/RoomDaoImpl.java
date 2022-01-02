package com.example.board.persistent;

import com.example.board.model.RoomVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("roomDao")
public class RoomDaoImpl implements RoomDao {
    @Autowired
    private SqlSession sqlSession;

    //숙소 등록
    public void insertRoom(RoomVo room) {
        this.sqlSession.insert("RoomDao.insertRoom", room);
    }

    //숙소 목록 조회
    public List<RoomVo> selectRoomList() {
        return this.sqlSession.selectList("RoomDao.selectRoomList");
    }

    //숙소 상세 조회
    public RoomVo selectRoom(int roomNo) {
        return this.sqlSession.selectOne("RoomDao.selectRoom", roomNo);
    }

    //숙소 수정
    public void updateRoom(RoomVo room) {
        this.sqlSession.update("RoomDao.updateRoom", room);
    }

    //숙소 삭제
    public void deleteRoom(int roomNo) {
        this.sqlSession.delete("RoomDao.deleteRoom", roomNo);
    }
}
















