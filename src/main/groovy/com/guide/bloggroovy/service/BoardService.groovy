package com.guide.bloggroovy.service

import com.guide.bloggroovy.domain.Board
import com.guide.bloggroovy.repository.BoardRepository
import lombok.RequiredArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class BoardService {

    private final BoardRepository boardRepository

    @Autowired
    BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository
    }

    Long save(Board board) {
        boardRepository.save(board);
        return board.getId()
    }


}
