package com.daelim.database.service

import com.daelim.database.dto.Chat
import com.daelim.database.repository.ChatRepository
import org.springframework.data.redis.core.StringRedisTemplate

class ChatService (
    private val chatRepository: ChatRepository,
    private val redisTemplate: StringRedisTemplate // Redis 템플릿 추가
){

    fun postChat (time : String, username : String, chat : String ) {
        val chat = Chat(time = time, username = username, chat = chat)
        return chatRepository.save(chat)
    }

}