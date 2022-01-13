package com.example.common.community;

import com.example.alarm.model.AlarmVo;
import com.example.member.model.MemberVo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : 김소진
 * @Title : 실시간 알림 웹소켓 핸들러
 * @date : 2022. 01. 04.
 */
@Component
@Slf4j
public class AlarmHandler extends TextWebSocketHandler {
    //로그인 한 전체
    //private static List<WebSocketSession> list = new ArrayList<>();

    private final ObjectMapper objectMapper = new ObjectMapper();

    // 1대1
    Map<Integer, WebSocketSession> users = new ConcurrentHashMap<Integer, WebSocketSession>();

    /* Client가 접속 시 호출되는 메서드 */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {

        //list.add(session);

        Integer memNo = getMemberId(session);
        System.out.println("응ㅁ..." + memNo);

        if (memNo != null) {    // 로그인 값이 있는 경우만
            users.put(memNo, session);
            System.out.println("총 몇명: " + users.toString());
            WebSocketSession targetSession = users.get(memNo);
        }
    }

    /* Client가 메세지 전송시 호출되는 메서드 */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

        Integer memNo = getMemberId(session);

        String msg = message.getPayload();

        if (msg != null) {
            // Json객체 → Java객체
            AlarmVo alarm = objectMapper.readValue(msg, AlarmVo.class);
            String content = alarm.getContent();
            String url = alarm.getUrl();
            String type = alarm.getType();

            // 접속중인 회원 목록중에 목표 회원에게 발송한다.
            WebSocketSession targetSession = users.get(alarm.getMemNo());  // 메시지를 받을 세션 조회
            // 목표 회원이 실시간 접속시 발송한다.
            if (targetSession != null) {
                TextMessage tmpMsg = new TextMessage(msg);
                targetSession.sendMessage(tmpMsg);
            }
            System.out.println("메세지 보내: " + alarm.toString());
        }
    }

    /* Client가 접속 해제 시 호출되는 메서드드 */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        Integer memNo = getMemberId(session);
        if (memNo != null) {    // 로그인 값이 있는 경우만
            users.remove(memNo);
//            list.remove(session);
        }
    }

    // 에러 발생시
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        log.info(session.getId() + " 익셉션 발생: " + exception.getMessage());
    }

    // 접속한 유저의 http세션을 조회하여 id를 얻는 함수
    private int getMemberId(WebSocketSession session) {
        Map<String, Object> httpSession = session.getAttributes();
        MemberVo loginUser = (MemberVo) httpSession.get("member");
        return loginUser.getMemNo();
    }
}