package com.daelim.database.repository

import com.daelim.database.dto.Chat
import org.springframework.data.jpa.repository.JpaRepository

interface ChatRepository : JpaRepository<Chat, Long> {
    fun findByUsername(username:String):Chat? // 유저네임을 주면 그에 맞는 채팅을 찾아줌

//    fun findByUsernameAndPassword(username:String, password:String):Chat?
    // 유저네임, 비밀번호를 주면 그에 맞는 채팅을 찾아줌 (필요없음)


}