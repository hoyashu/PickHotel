package com.example.board;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoomVo {
    private int roomNo;
    private String roomName;
    private String roomDeco;
    private String roomAddress;
    private String systemFileName;
    private String originalFileName;
}
