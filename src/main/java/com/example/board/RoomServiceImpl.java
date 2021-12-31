package com.example.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roomService")
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomDaoImpl roomDao;

    //숙소 등록
    public void registerRoom(RoomVo room) {
        this.roomDao.insertRoom(room);
    }

    //숙소 목록 조회
    public List<RoomVo> retrieveRoomList() {
        return this.roomDao.selectRoomList();
    }

    //숙소 상세 조회
    public RoomVo retrieveRoom(int id) {
        return this.roomDao.selectRoom(id);
    }

    //숙소 수정
    public void modifyReview(RoomVo room) {
        this.roomDao.updateRoom(room);
    }

    //숙소 삭제
    public RoomVo removeRoom(int id) {

        //숙제 존재여부 확인
        RoomVo room = retrieveRoom(id);

        //숙소가 존재할 경우
        if (room != null) {
            //숙소를 삭제한다.
            this.roomDao.deleteRoom(id);
            //삭제한 숙소 정보 리턴
            return room;
        }
        return null;
    }
}
