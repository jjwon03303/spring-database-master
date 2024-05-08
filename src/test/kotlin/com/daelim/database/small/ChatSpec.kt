package com.daelim.database.small

import com.daelim.database.core.entity.ChatEntity
import org.springframework.boot.test.context.SpringBootTest
import net.datafaker.Faker
import org.apache.juli.logging.Log
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.time.LocalDateTime


@SpringBootTest
class ChatSpec {
    private val faker = Faker()

    private lateinit var randomChat : ChatEntity

    @BeforeEach //시작하기 전에 실행될 메서드를 저장해둠.
    // username과 password가 테스트마다 새롭게 들어감
    fun setup() {
        val username = faker.internet().username()
        val chat = faker.lorem().sentence(5, 3)
        randomChat = ChatEntity(
            time = LocalDateTime.now().toString(),
            username = username,
            chat = chat,
        )
    }

    //테스트로 지정되어있다면 왼쪽의 재생버튼을 누르면 테스트코드로 실행된다
    @Test
    @DisplayName("chat이 70자 이내인지 확인")
    fun `"chat이 70자 이내인지 확인"`() {

        // When
        val rdChat = randomChat.chat

        //log println
        println("rdchat: $rdChat")
        println("rdchat length : ${rdChat.length}")

        // Then
        Assertions.assertTrue(rdChat.length <= 70)
        //rdChat의 길이가 70자 이하라면
    }

    @Test
    @DisplayName("a라는 단어가 있는지 확인하고, 있다면 a를 b로 바꾸기")
    fun `"a라는 단어가 있는지 확인하고, 있다면 a를 b로 바꾸기"`() {

        // When
        val rdChat = randomChat.chat


        println("단어체크 rdchat: $rdChat")

        // Then

        //rdChat 내부의 a를 b로 변경 (추후 필터링 기능으로 수정 가능)
        val changedChat = rdChat.replace("a","b")
        //왜 replace가 안먹히는가??
        //string.replace해주고 그걸 따로 다른 변수에 저장안해줘서 생긴 에러였음

        println("단어체크 rdchat 변환 후 : ${changedChat}")

        assertFalse(changedChat.contains('a'))
        //a를 가지고 있는게 False이여야함

    }
}