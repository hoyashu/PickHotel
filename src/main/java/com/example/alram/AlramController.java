package com.example.alram;

import org.springframework.web.bind.annotation.GetMapping;

public class AlramController {

    // ######## 이벤트 관리 ########
    @GetMapping("/intranet/event_list")
    public String eventList() {
        return "page/intranet/event_list";
    }

    // ######## 통계 관리 ########
    @GetMapping("/intranet/statistics")
    public String statistics() {
        return "page/intranet/statistics";
    }
}
