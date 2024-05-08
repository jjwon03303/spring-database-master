package com.daelim.database.controller

import com.daelim.database.dto.User
import com.daelim.database.service.ChatService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

class ChatController (private val chatService: ChatService) {
    @PostMapping("/chat")
    fun register(
        @RequestParam username: String,
        @RequestParam password: String
    ): ResponseEntity<User> {
        return ResponseEntity.ok(chatService.postChat(username, password))
    }
}