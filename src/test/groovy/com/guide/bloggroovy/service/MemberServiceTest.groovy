package com.guide.bloggroovy.service

import com.guide.bloggroovy.domain.Member
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional

import static org.junit.Assert.assertEquals

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class MemberServiceTest {
    @Autowired
    MemberService memberService;

    @Test
    void 회원가입() {
        //given
        Member member = Member.createMember("A", "a", "1234", null);

        //when
        Long id = (Long) memberService.join(member);

        //then
        assertEquals(member, memberService.findOne(id));
    }
}
