package com.example.demo;



import com.example.member.model.MemberVo;
import com.example.member.persistent.MemberDao;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;





import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@MybatisTest
@Slf4j
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MemberDaoTest {

	@Autowired
	private MemberDao memberDao;

//	@Test
//	void test2() {
//		Map<String, Object> map = new HashMap<String, Object>();
//
//		map.put("name", "홍길동");
//		map.put("birth", "1999-01-01");
//
//		List<MemberVo> findIdResultList = this.memberDao.selectNBMemberList(map);
//
//		for (MemberVo member: findIdResultList) {
//			log.info("FindByID : " + member);
//		}
//	}


}
