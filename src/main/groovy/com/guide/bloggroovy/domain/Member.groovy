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

@Entity
class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id

    @NonNull private String nickname
    @NonNull private String password
    @NonNull private String loginId
    @NonNull private LocalDateTime createDate

    @Setter private String email

    //생성자
    private Member(String nickname, String password, String loginId, String email) {
        this.nickname = nickname
        this.password = password
        this.loginId = loginId
        this.email = email
        this.createDate = LocalDateTime.now()
    }

    protected Member() {}

    //Setter
    void setNickname(String nickname) {
        this.nickname = nickname
    }

    void setPassword(String password) {
        this.password = password
    }

    void setEmail(String email) {
        this.email = email
    }

    //Getter
    Long getId() {
        return id
    }

    String getNickname() {
        return nickname
    }

    String getPassword() {
        return password
    }

    String getLoginId() {
        return loginId
    }

    LocalDateTime getCreateDate() {
        return createDate
    }

    String getEmail() {
        return email
    }

    //생성 메소드
    static Member createMember(String nickname, String loginId, String password, String email) {
        return new Member(nickname, password, loginId, email)
    }
}
