package com.example.board;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("roomDao")
public class RoomDao {
	@Autowired
	private SqlSession sqlSession;

	public void insertRoom(RoomVo room){
		this.sqlSession.insert("RoomDao.insertRoom", room);
	}

	public void deleteRoom(int roomNo){
		this.sqlSession.delete("RoomDao.deleteRoom", roomNo);
	}

	public List<RoomVo> selectRoomList(){
		return this.sqlSession.selectList("RoomDao.selectRoomList");
	}

	public RoomVo selectRoom(int roomNo){
		return this.sqlSession.selectOne("RoomDao.selectRoom", roomNo);
	}

}
















