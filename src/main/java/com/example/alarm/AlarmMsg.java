package com.example.alarm;

public enum AlarmMsg {
    COMMENT_DEP1("내 게시글에 댓글이 달렸어요."),
    COMMENT_DEP2("내 댓글에 답글이 달렸어요."),
    COMMENT_DEP3("멘션되었습니다."),
    GRADEUP("등급으로 등업되었어요. 축하드려요!"),
    GRADEUPFAIL("등업신청이 반려되었어요."),
    REPORT("내 게시글에 신고가 들어왔어요.");

    private final String value;

    AlarmMsg(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

