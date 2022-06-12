package com.guide.bloggroovy.domain

import lombok.Getter
import lombok.NonNull
import lombok.Setter

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import java.time.LocalDateTime

@Entity @Getter
class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id

    @Setter @NonNull
    private String nickname
    @Setter @NonNull
    private String password
    @NonNull private String loginId
    @NonNull private LocalDateTime createDate

    @Setter private String email

    Member(String nickname, String password, String loginId, String email) {
        this.nickname = nickname
        this.password = password
        this.loginId = loginId
        this.email = email
        this.createDate = LocalDateTime.now()
    }

    protected Member() {}
}
