package com.example.common.community;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class WebSoketController {

    //실시간 채팅
    @GetMapping("/chat")
    public String chatGET() {

        log.info("@ChatController, chat GET()");

        return "page/chat";
    }

    //실시간 알림 - 프론트에서 /alarm 접근시 page/alarm파일을 오픈한다.
    @GetMapping("/alarm")
    public String alarmGET() {

        log.info("@AlarmController, chat GET()");

        return "page/alarm";
    }
}