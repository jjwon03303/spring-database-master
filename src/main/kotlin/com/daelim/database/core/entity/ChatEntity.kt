package com.daelim.database.core.entity

import jakarta.persistence.*
import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime
import java.time.LocalDateTime
import java.util.Date

@Entity
@Table(name = "chats")
data class Chat(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var time: String? = null,
    var username: String,
    var chat: String
)