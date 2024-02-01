package io.vtou.vitamintou.domain.users.domain;

import io.vtou.vitamintou.core.exception.enums.ErrorCode;
import io.vtou.vitamintou.domain.users.exception.UserException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // 기기 UUID
    @Column(name = "device_uuid", nullable = false, unique = true)
    private String deviceUUID;

    // 유저 닉네임
    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Builder
    private User(String deviceUUID, String nickname) {
        verifyDeviceUUID(deviceUUID);
        verifyNickname(nickname);
        this.deviceUUID = deviceUUID;
        this.nickname = nickname;
    }

    public void updateValues(String deviceUUID, String nickname) {
        this.setDeviceUUID(deviceUUID);
        this.setNickname(nickname);
    }

    private void setDeviceUUID(String deviceUUID) {
        verifyDeviceUUID(deviceUUID);
        this.deviceUUID = deviceUUID;
    }

    private void setNickname(String nickname) {
        verifyNickname(nickname);
        this.nickname = nickname;
    }

    private void verifyDeviceUUID(String deviceUUID) {
        if (deviceUUID.isBlank()) {
            throw new UserException(ErrorCode.USER_UUID_NOT_BLANK);
        }
    }

    private void verifyNickname(String nickname) {
        if (nickname.isBlank()) {
            throw new UserException(ErrorCode.USER_NICKNAME_NOT_BLANK);
        }
    }

}
