package com.example.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("roomService")
public class RoomService {
	
	@Autowired
	private RoomDao roomDao;
	
	public ArrayList<RoomVo> retrieveRoomList(){
		return roomDao.selectRoomList();
	}
}
