package com.guide.bloggroovy.repository

import com.guide.bloggroovy.domain.Member
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
class MemberRepositoryTest {

    @Autowired private MemberRepository memberRepository

    @Test
    void 회원가입() {
        //given
        Member member = Member.createMember("A", "a", "1234", null)

        //when
        memberRepository.save(member)

        //then


    }
}
