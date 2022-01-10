package com.example.alram.controller;

import com.example.alram.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

public class AlramController {
    @Autowired
    private AlarmService alarmService;

    // ######## 알람 삭제 ########
    @ResponseBody
    @PostMapping("/alarm/delect/{no}")
    public String delect(@PathVariable("no") int no, HttpServletRequest request) {

//        System.out.println("삭제욧청");
//        // 1.추가할 알림 정보를 받아온다.
//        int alarmNo = Integer.parseInt(request.getParameter("alarmNo"));
//        System.out.println("no" + alarmNo);
//        int memNo = Integer.parseInt(request.getParameter("memNo"));
//        System.out.println("memNo" + memNo);
//
//        //2. 세션에 저장된 회원no와 같은지 비교할 것
//        System.out.println("삭제요청ㅇㅇ");
//
//        // 3. DB에서 특정 알림을 삭제한다.
//        alarmService.deleteBoard(no);

        return "page/intranet/statistics";
    }

    // ######## 통계 관리 ########
    @GetMapping("/intranet/statistics")
    public String statistics() {
        return "page/intranet/statistics";
    }
}
