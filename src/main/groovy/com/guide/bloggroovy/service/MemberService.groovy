package com.guide.bloggroovy.service

import com.guide.bloggroovy.repository.BoardRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
class MemberService {

    private final BoardRepository boardRepository


}
