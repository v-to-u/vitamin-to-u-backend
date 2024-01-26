package io.vtou.vitamintou.domain.users.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_tb")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
public class User {

    // 기기 UUID
    @Id
    @Column(name = "device_uuid", nullable = false, unique = true)
    private String deviceUUID;

    // 유저 닉네임
    @Column(name = "nickname", nullable = false)
    private String nickname;

}
