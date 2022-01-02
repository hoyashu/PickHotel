package com.example.note.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class NoteVo {
    int noteIdentifySendGetCode;
    private int noteNo;
    private String noteCon;
    private int noteGetmbNo;
    private int noteSendmbNo;
    private int noteGetmbDelState;
    private int noteGetmbSaveState;
    private int noteGetmbReadState;
    private int noteSendmbDelState;
    private int noteSendmbSaveState;
    private String noteDateTime;
}