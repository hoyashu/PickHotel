package com.example.board.controller;

import com.example.board.model.MapResponseForApi;
import com.example.board.service.MapServiceForApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class MapController {
    @Autowired
    private MapServiceForApi mapServiceForApi;

    // 게시글 목록
    @GetMapping("/map")
    public String map() {
        return "page/map";
    }

    // 게시글 목록
    @ResponseBody
    @GetMapping("/map/list")
    public MapResponseForApi allMapsApi() {
        return this.mapServiceForApi.retrieveAllMaps();
    }
}
