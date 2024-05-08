package com.daelim.database.service

import com.daelim.database.dto.Chat
import com.daelim.database.repository.ChatRepository
import org.springframework.data.redis.core.StringRedisTemplate
import java.time.LocalDate

class ChatService (
    private val chatRepository: ChatRepository,
    private val redisTemplate: StringRedisTemplate // Redis 템플릿 추가
){

    fun postChat (username : String, chat : String ) {
        val chat = Chat(time = LocalDate.now().toString(), username = username, chat = chat)
        return chatRepository.save(chat)
    }

}