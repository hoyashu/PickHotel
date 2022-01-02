package com.example.event.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class EventAdminController {
    // ######## 이벤트 관리 ########
    @GetMapping("/intranet/event_list")
    public String eventList() {
        return "page/intranet/event_list";
    }

}
