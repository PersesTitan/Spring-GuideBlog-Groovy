package com.guide.bloggroovy.service

import com.guide.bloggroovy.domain.Member
import com.guide.bloggroovy.repository.MemberRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class MemberService {

    private final MemberRepository memberRepository

    MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository
    }

    @Transactional
    Long join(Member member) {
        validateDuplicateMember(member)
        memberRepository.save(member)
        return member.getId()
    }

    //중복 체크
    private def validateDuplicateMember(Member member) {
        String loginId = member.getLoginId()
        String nickname = member.getNickname()
        List<Member> loginIdList = memberRepository.findByLoginId(loginId)
        if (!loginIdList.isEmpty()) throw new IllegalStateException("존재하는 아이디 입니다.")
        List<Member> nickName = memberRepository.findByNickName(nickname)
        if (!nickName.isEmpty()) throw new IllegalStateException("존재하는 닉네임 입니다.")
    }

    Member findOne(Long id) {
        return memberRepository.findOne(id)
    }

    List<Member> findAll() {
        return memberRepository.findAll()
    }
}
