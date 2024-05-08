package com.daelim.database.controller

import com.daelim.database.core.dto.Chat
import com.daelim.database.core.dto.User
import com.daelim.database.service.ChatService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ChatController (private val chatService: ChatService) {
    @PostMapping("/chat")
    fun register(
        @RequestParam username: String,
        @RequestParam chat: String
    ): ResponseEntity<Chat> {
        return ResponseEntity.ok(chatService.postChat(username, chat))
    }
}