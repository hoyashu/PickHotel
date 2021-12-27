package com.example.board;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
public class PostVo {
	private int postNo;
	private int boardNo;
	private String subject;
	private String content;
	private String createDate;
	private int writerNo;
	private String writerNick;
	private String tag;
	private int views;
	private int blind;
	private ArrayList<AttachVo> attachList = new ArrayList<AttachVo>();
	private ReviewVo review;

}
