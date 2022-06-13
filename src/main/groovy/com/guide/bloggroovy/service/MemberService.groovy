package com.guide.bloggroovy.service

import com.guide.bloggroovy.domain.Member
import com.guide.bloggroovy.repository.MemberRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
class MemberService {

    private final MemberRepository memberRepository

    @Transactional
    Long join(Member member) {

        memberRepository.save(member)
        return member.getId()
    }

}
