package com.guide.bloggroovy.repository

import com.guide.bloggroovy.domain.Member
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Repository

import javax.persistence.EntityManager

@Repository
@RequiredArgsConstructor
class MemberRepository {

    private final EntityManager em;

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
}
