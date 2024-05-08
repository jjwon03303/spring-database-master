package com.daelim.database.service

import com.daelim.database.dto.Chat
import com.daelim.database.repository.ChatRepository
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class ChatService (
    private val chatRepository: ChatRepository,
    private val redisTemplate: StringRedisTemplate // Redis 템플릿 추가
){

    fun postChat (username : String, chat : String ): Chat {
        val chat = Chat(time = LocalDate.now().toString(), username = username, chat = chat)
        return chatRepository.save(chat)
    }

}