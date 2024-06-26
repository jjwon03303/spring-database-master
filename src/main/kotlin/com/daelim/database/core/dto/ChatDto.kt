package com.daelim.database.core.dto

import jakarta.persistence.*
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