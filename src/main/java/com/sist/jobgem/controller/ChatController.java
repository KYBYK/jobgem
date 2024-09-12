package com.sist.jobgem.controller;

import com.sist.jobgem.dto.ChatDto;
import com.sist.jobgem.dto.ChatroomResponseDto;
import com.sist.jobgem.service.ChatService;
import com.sist.jobgem.service.ChatroomService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ChatController {

    private final SimpMessageSendingOperations template;

    @Autowired
    private ChatroomService chatroomService;
    @Autowired
    private ChatService chatService;

    // 채팅 리스트 반환
    @GetMapping("/chatroom")
    public ResponseEntity<List<ChatroomResponseDto>> getChatMessages(@RequestParam int id) {
        return ResponseEntity.ok(chatroomService.getChatroomList(id));
    }

    // 해당 채팅방의 채팅들
    @GetMapping("/chatroom/{id}/chat")
    public ResponseEntity<List<ChatDto>> getChatList(@PathVariable int id) {
        return ResponseEntity.ok(chatService.getChatList(id));
    }

    //메시지 송신 및 수신, /pub가 생략된 모습. 클라이언트 단에선 /pub/message로 요청
    @MessageMapping("/chat")
    public ResponseEntity<ChatDto> receiveMessage(@RequestBody ChatDto chat) {
        ChatDto chatDto = chatService.addChat(chat);
        if(chatDto == null) template.convertAndSend("/sub/chatroom/"+chat.getCmIdx(), chat);
        return ResponseEntity.ok(chatDto);
    }
}