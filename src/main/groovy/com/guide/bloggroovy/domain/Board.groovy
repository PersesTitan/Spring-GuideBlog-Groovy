package com.guide.bloggroovy.domain

import lombok.AccessLevel
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.NonNull
import lombok.Setter

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import java.time.LocalDateTime

import static javax.persistence.FetchType.*

@Entity @Getter
class Board {

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long id

    @NonNull @Setter
    private String title
    @NonNull @Setter
    private String content

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member

    private LocalDateTime createDate

    private Board(String title, String content, Member member) {
        this.title = title
        this.content = content
        this.member = member
        this.createDate = LocalDateTime.now()
    }

    protected Board() {}

    //생성 메소드
    static createBoard(Member member, String title, String content) {
        return new Board(title, content, member);
    }
}
