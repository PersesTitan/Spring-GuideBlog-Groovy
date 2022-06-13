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

@Entity
class Board {

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long id

    @NonNull private String title
    @NonNull private String content

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member

    private LocalDateTime createDate

    //생성자
    private Board(String title, String content, Member member) {
        this.title = title
        this.content = content
        this.member = member
        this.createDate = LocalDateTime.now()
    }

    protected Board() {}

    //Setter
    void setTitle(String title) {
        this.title = title
    }

    void setContent(String content) {
        this.content = content
    }

    //Getter
    Long getId() {
        return id
    }

    String getTitle() {
        return title
    }

    String getContent() {
        return content
    }

    Member getMember() {
        return member
    }

    LocalDateTime getCreateDate() {
        return createDate
    }

    //생성 메소드
    static createBoard(Member member, String title, String content) {
        return new Board(title, content, member);
    }
}
