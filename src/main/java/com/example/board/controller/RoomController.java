package com.example.board.controller;

import com.example.board.model.RoomVo;
import com.example.board.service.RoomService;
import com.example.common.restAPI.RoomResourceAssembler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/*
사용자 API
 */
@RestController
@RequestMapping(path = "/api/v1")
@Slf4j
public class RoomController {

    @Autowired
    private RoomResourceAssembler roomResourceAssembler;

    @Autowired
    private RoomService roomService;

    // ########## 숙소 목록 조회 API ########## //
    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    public CollectionModel<EntityModel<RoomVo>> retriveAllRooms() {
        List<RoomVo> rooms = roomService.retrieveRoomList();
        return roomResourceAssembler.toCollectionModel(rooms);
    }

    // ########## 숙소 상세 조회 ########## //
    @RequestMapping(value = "/rooms/{id}", method = RequestMethod.GET)
    public EntityModel<RoomVo> retriveRoomById(@PathVariable("id") int id) {

        RoomVo room = roomService.retrieveRoom(id);
        if (room == null) {
            throw new RuntimeException("존재하지 않는 숙소입니다.");
        }

        return roomResourceAssembler.toModel(room);
    }


    // ########## 숙소 등록 ########## //
    @RequestMapping(value = "/rooms", method = RequestMethod.POST)
    public ResponseEntity createRoom(@Validated @RequestBody RoomVo room) {
        //입력값으로부터 도메인 객체를 작성한다.
        this.roomService.registerRoom(room);

        URI resourceUrl = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(room.getRoomNo())
                .toUri();

        //created 상태코드가 201번인 것
        return ResponseEntity.created(resourceUrl).build();
    }

    // ########## 숙소 정보 수정 ########## //
    @RequestMapping(value = "/rooms/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateRoom(@Validated @RequestBody RoomVo room) {

        RoomVo room1 = roomService.retrieveRoom(room.getRoomNo());
        if (room1 == null) {
            throw new RuntimeException("존재하지 않는 숙소입니다.");
        }

        //입력값으로부터 도메인 객체를 수정한다.
        this.roomService.modifyReview(room);

        URI resourceUrl = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(room.getRoomNo())
                .toUri();

        //created 상태코드가 201번인 것
        return ResponseEntity.created(resourceUrl).build();
    }

    // ########## 숙소 삭제 ########## //
    @DeleteMapping("/rooms/{id}")
    public ResponseEntity<String> removeRoom(@PathVariable Integer id) {
        RoomVo room = this.roomService.removeRoom(id);

        if (room != null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
