package com.darfik.mishanyacoin.service;

import com.darfik.mishanyacoin.dto.RegistrationRequest;
import com.darfik.mishanyacoin.dto.UserInfoResponse;
import com.darfik.mishanyacoin.model.User;
import com.darfik.mishanyacoin.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void createUser(RegistrationRequest registrationRequest) {
        userRepository.save(new User(registrationRequest.username(), registrationRequest.username()));
    }

    @Override
    public UserInfoResponse getById(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("User " + id + " doesn't exist"));
        return new UserInfoResponse(user.getId(), user.getUsername());
    }

}
