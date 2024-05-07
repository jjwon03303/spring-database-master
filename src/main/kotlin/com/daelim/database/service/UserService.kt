package com.daelim.database.service

import com.daelim.database.dto.User
import com.daelim.database.repository.UserRepository
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit

@Service
class UserService(
    private val userRepository: UserRepository,
    private val redisTemplate: StringRedisTemplate // Redis 템플릿 추가
) {
    fun registerUser(username: String, password: String): User {
        val user = User(username = username, password = password) // 비밀번호는 암호화 처리 필요
        return userRepository.save(user)
    }

    fun validateUser(username: String, password: String): Boolean {
        //username과 password를 받아옴
        val user = userRepository.findByUsername(username)
        // username을 가진 유저가 있다면 그 정보를 받아옴
        return user?.password == password
        //입력한 비밀번호랑 입력한 username의 비밀번호값을 대조해서 맞는지 확인하고, 맞으면 T 틀리면 F 반환
    }

    fun createSession(username: String): String {
        val sessionId = generateSessionId(username)
        //username에 대한 세션 아이디를 생성함 (String값이다)
        redisTemplate.opsForValue().set("session:$username", sessionId, 30, TimeUnit.MINUTES) // 세션 유효 시간 30분
        // key값, value값, 타임아웃값, 타임어쩌구로 조정됨
        return sessionId
    }

    fun checkSession(username: String, sessionId: String): Boolean {
        val storedSessionId = redisTemplate.opsForValue().get("session:$username")
        //username에 대한 키 값을 받아오겠다
        return sessionId == storedSessionId
        //값이 있다면 T return if not F return
    }

    private fun generateSessionId(username: String): String {
        return username.hashCode().toString() + System.currentTimeMillis().toString()
    }
}
