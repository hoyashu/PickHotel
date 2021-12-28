package com.example.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("roomService")
@Transactional
public class RoomService {

	@Autowired
	private RoomDao roomDao;

	public void registerRoom(RoomVo room){
		this.roomDao.insertRoom(room);
	}

	public void removeRoom(int roomNo){
		this.roomDao.deleteRoom(roomNo);
	}

	public List<RoomVo> retrieveRoomList(){
		return this.roomDao.selectRoomList();
	}

	public RoomVo retrieveRoom(int roomNo) {
		return this.roomDao.selectRoom(roomNo);
	}

}
