//package com.example.member.service;
//
//import com.example.demo.PickHotel2Application;
//import com.example.member.model.MemberVo;
//import org.junit.Test;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Nested;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = PickHotel2Application.class)
//@DisplayName("memberTest")
//public class memberTest {
//
//    /* ! 필수 ! */
//    @Autowired
//    private MemberService memberService;
//
//    @Nested
//    @DisplayName("increase 메소드 - DataJpaTest 어노테이션을 사용하는 테스트")
//    class Describe_increase {
//        @Nested
//        @DataJpaTest  /* ! 필수 ! */
//        @DisplayName("저장된 멤버 객체의 아이디와 증가할 숫자가 주어지면")
//        class Context_with_a_member {
//            final int givenNumber = 1;
//            final String givenName = "홍길동";
//            MemberVo member;
//
//            int givenMemNo() {
//                return member.getMemNo();
//            }
//
//            @BeforeEach
//            void preapre() {
//                MemberVo member = new MemberVo(1, "id", "pwd", "홍길동", "닉네임", "F", "010-0000-0000", "1998-04-10", "2022-10-10 10:10:10", "1", 0, 0, 0, 1, "등급명");
//                Map<String, Object> map = new HashMap<String, Object>();
//                map.put("id", member.getId());
//                map.put("nick", member.getNick());
//                map.put("name", member.getName());
//                map.put("pwd", member.getPwd());
//                map.put("gender", member.getGender());
//                map.put("hp", member.getHp());
//                map.put("birth", member.getBirth());
//                memberService.registerMember(map);
//            }
//
//            @Test
//            @DisplayName("방문 카운트를 증가시키고, 업데이트된 레코드 수를 리턴한다")
//            void it_increases_count_and_returns_count_of_updated_records() {
//                Assertions.assertEquals(member.getVisitCount(), 0,
//                        "실행 전의 카운트는 0 이다");
//
//                final int updatedRecords = memberService.reviseVisitCount(givenMemNo());
//
//                Assertions.assertEquals(updatedRecords, 1,
//                        "한 건이 업데이트되었다");
//                Assertions.assertEquals(
//                        givenNumber,
//                        memberService.retrieveMember(givenMemNo()).getVisitCount(),
//                        "주어진 증가 숫자만큼 방문 카운트가 증가한다"
//                );
//            }
//        }
//    }
//
//}
