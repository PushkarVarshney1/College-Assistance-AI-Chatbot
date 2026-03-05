package com.varshneypushkar01.chatbot.controller;

import com.varshneypushkar01.chatbot.service.ChatService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class ChatController {
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }
//    @GetMapping
//    public String chat(@RequestParam String message) {
//        return "You said: " + message;
//    }
    @GetMapping
    public String chat(@RequestParam String message) {
        return chatService.getResponse(message);
    }
}
