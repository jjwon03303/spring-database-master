package com.daelim.database.repository

import com.daelim.database.core.dto.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByUsername(username:String): User?

    fun findByUsernameAndPassword(username:String, password:String): User?

}