package io.vtou.vitamintou.domain.users.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.vtou.vitamintou.domain.users.exception.UserException;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test User Entity")
class UserTest {

    @Test
    void testCreateUserSuccess() {
        // Arrange
        String expectedDeviceUUID = UUID.randomUUID().toString();
        String expectedNickname = "test";
        // Act
        var actualResult = User.builder()
            .deviceUUID(expectedDeviceUUID)
            .nickname(expectedNickname)
            .build();
        // Assert
        assertThat(actualResult)
            .hasFieldOrPropertyWithValue("deviceUUID", expectedDeviceUUID)
            .hasFieldOrPropertyWithValue("nickname", expectedNickname);
    }

    @DisplayName("test CreateUserFail when deviceUUID is blank string")
    @Test
    void testCreateUserFailWhenDeviceUUIDIsBlank() {
        // Arrange
        String expectedDeviceUUID = "";
        String expectedNickname = "test";
        // Act & Assert
        assertThrows(UserException.class, User.builder()
            .deviceUUID(expectedDeviceUUID)
            .nickname(expectedNickname)::build);
    }

    @DisplayName("test CreateUserFail when nickname is blank string")
    @Test
    void testCreateUserFailWhenNicknameIsBlank() {
        // Arrange
        String expectedDeviceUUID = UUID.randomUUID().toString();
        String expectedNickname = "";
        // Act & Assert
        assertThrows(UserException.class, User.builder()
            .deviceUUID(expectedDeviceUUID)
            .nickname(expectedNickname)::build);
    }

    @Test
    void testUpdateUserValuesSuccess() {
        // Arrange
        String expectedDeviceUUID = UUID.randomUUID().toString();
        String expectedNickname = "test";
        var expectedUser = User.builder()
            .deviceUUID(expectedDeviceUUID)
            .nickname(expectedNickname).build();
        expectedDeviceUUID = UUID.randomUUID().toString();
        // Act
        expectedUser.updateValues(expectedDeviceUUID, expectedNickname);
        // Assert
        assertThat(expectedUser)
            .hasFieldOrPropertyWithValue("deviceUUID", expectedDeviceUUID)
            .hasFieldOrPropertyWithValue("nickname", expectedNickname);
    }

    @Test
    void testUpdateUserValuesFail() {
        // Arrange
        String expectedDeviceUUID = UUID.randomUUID().toString();
        String expectedNickname = "test";
        var expectedUser = User.builder()
            .deviceUUID(expectedDeviceUUID)
            .nickname(expectedNickname).build();
        String expectWrongDeviceUUID = "";
        // Act & Assert
        assertThrows(UserException.class,
            () -> expectedUser.updateValues(expectWrongDeviceUUID, expectedNickname));
    }

}