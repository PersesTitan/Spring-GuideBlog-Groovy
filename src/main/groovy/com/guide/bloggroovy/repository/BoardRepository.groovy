package com.guide.bloggroovy.repository

import com.guide.bloggroovy.domain.Board
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

    void save(Board board) {
        em.persist(board);
    }

    Board findOne(Long boardId) {
        return em.find(Board.class, boardId)
    }

    List<Board> findAll() {
        return em.createQuery("SELECT B FROM Board AS B", Board.class)
                .getResultList()
    }
}
