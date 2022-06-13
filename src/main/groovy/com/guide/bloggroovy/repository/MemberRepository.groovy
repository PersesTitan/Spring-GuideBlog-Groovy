package com.guide.bloggroovy.repository

import com.guide.bloggroovy.domain.Member
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Repository

import javax.persistence.EntityManager

@Repository
class MemberRepository {

    private final EntityManager em;

    MemberRepository(EntityManager em) {
        this.em = em
    }

    void save(Member member) {
        em.persist(member)
    }

    //조회 로직
    Member findOne(Long id) {
        return em.find(Member.class, id)
    }

    List<Member> findAll() {
        return em.createQuery("SELECT Member FROM Member", Member.class)
                .getResultList()
    }

    //중복 체크
    List<Member> findByLoginId(String loginId) {
        return em.createQuery("SELECT M FROM Member AS M WHERE M.loginId = :loginId", Member.class)
                .setParameter("loginId", loginId)
                .getResultList();
    }

    List<Member> findByNickName(String nickName) {
        return em.createQuery("SELECT M FROM Member AS M WHERE M.nickname = :nickName", Member.class)
                .setParameter("nickName", nickName)
                .getResultList();
    }
}
