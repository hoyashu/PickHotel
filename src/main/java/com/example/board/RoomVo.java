package com.example.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomVo {
	private int no;
	private String roomName;
	private String roomDeco;
	private String roomAddress;
	private String systemFileName;
	private String originalFileName;

}
