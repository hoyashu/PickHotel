package com.example.board;

import java.util.List;

public interface RoomService {
    //숙소 등록
    void registerRoom(RoomVo room);

    //숙소 목록 조회
    List<RoomVo> retrieveRoomList();

    //숙소 상세 조회
    RoomVo retrieveRoom(int id);

    //숙소 수정
    void modifyReview(RoomVo room);

    //숙소 삭제
    RoomVo removeRoom(int id);
}
