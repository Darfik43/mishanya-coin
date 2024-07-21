package com.darfik.mishanyacoin.service;

import com.darfik.mishanyacoin.dto.RegistrationRequest;
import com.darfik.mishanyacoin.dto.UserInfoResponse;
import com.darfik.mishanyacoin.exception.UserAlreadyExistsException;
import com.darfik.mishanyacoin.model.User;
import com.darfik.mishanyacoin.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createUser_userDoesNotExist_createUser() {
        RegistrationRequest registrationRequest = new RegistrationRequest("test");

        when(userRepository.existsById(registrationRequest.username())).thenReturn(false);

        userService.createUser(registrationRequest);

        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void createUser_userAlreadyExists_throwsException() {
        RegistrationRequest registrationRequest = new RegistrationRequest("test");

        when(userRepository.existsById(registrationRequest.username())).thenReturn(true);

        assertThrows(UserAlreadyExistsException.class, () -> userService.createUser(registrationRequest));

        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void getById_userExists_returnsUserInfo() {
        User user = new User("userId", "username");

        when(userRepository.findById("userId")).thenReturn(Optional.of(user));

        UserInfoResponse userInfoResponse = userService.getById("userId");

        assertEquals("userId", userInfoResponse.id());
        assertEquals("username", userInfoResponse.username());
    }

    @Test
    void getById_userDoesNotExist_throwsException() {
        when(userRepository.findById("userId")).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> userService.getById("userId"));
    }

}
