package com.guide.bloggroovy.repository

import lombok.RequiredArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

import javax.persistence.EntityManager

@Repository
class BoardRepository {

    private final EntityManager em

    @Autowired
    BoardRepository(EntityManager em) {
        this.em = em
    }

}
