package com.example.alram.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class AlarmVo {

    private int no;
    private String alarmType;
    private int alarmRead;
    private String alarmContent;
    private String alarmUrl;
    private int memNo;

}