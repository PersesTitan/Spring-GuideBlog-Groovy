package com.guide.bloggroovy.repository

import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Repository

import javax.persistence.EntityManager

@Repository
@RequiredArgsConstructor
class BoardRepository {

    private final EntityManager em

}
