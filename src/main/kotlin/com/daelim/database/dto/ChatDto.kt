package com.daelim.database.dto

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime
import java.time.LocalDateTime
import java.util.Date

@Entity
data class Chat(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var time: String? = null,
    var username: String,
    var chat: String
)