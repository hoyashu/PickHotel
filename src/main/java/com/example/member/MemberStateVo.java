package com.example.member;

import com.example.paging.CommonVo;
import groovy.transform.ToString;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ToString
public class MemberStateVo extends CommonVo {
	private int stateNo;
	private int memNo;
	private String reason;
	private String withdrawDate;
	
	public MemberStateVo() {
		super();
	}
	
	public MemberStateVo(int memNo, String reason) {
		super();
		this.memNo = memNo;
		this.reason = reason;
	}
}
