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
import java.time.LocalDateTime

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    private Member(String nickname, String password, String loginId, String email) {
        this.nickname = nickname
        this.password = password
        this.loginId = loginId
        this.email = email
        this.createDate = LocalDateTime.now()
    }

    //생성 메소드
    static Member createMember(String nickname, String loginId, String password, String email) {
        return new Member(nickname, password, loginId, email)
    }
}
