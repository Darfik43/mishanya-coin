package com.darfik.mishanyacoin.service;

import com.darfik.mishanyacoin.dto.RegistrationRequest;
import com.darfik.mishanyacoin.model.User;
import com.darfik.mishanyacoin.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void createUser(RegistrationRequest registrationRequest) {
        userRepository.save(new User(registrationRequest.username(), registrationRequest.username()));
    }

    @Override
    public User getById(String id) {
        System.out.println(userRepository.findById(id).get());
        return userRepository.findById(id).get();
    }

}
