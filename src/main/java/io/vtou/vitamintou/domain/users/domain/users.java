package io.vtou.vitamintou.domain.users.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
public class users {
    // 유저 id
    @Id
    @Column(name = "user_id", nullable = false,updatable = false)
    private String userId;

    // 유저 이름
    @Column(name = "user_name", nullable = false)
    private String userName;

    // 유저 password
    @Column(name="user_password",nullable = false)
    private String userPassword;

    // 유저 email
    @Column(name="user_email",nullable = false)
    private String userEmail;

    // 유저 생성시점
    @Column(name="created_at",nullable = false,updatable = false)
    private LocalDate createdAt;

    // 유저 수정시점
    @Column(name="updated_at",nullable = false)
    private LocalDate updatedAt;

}
