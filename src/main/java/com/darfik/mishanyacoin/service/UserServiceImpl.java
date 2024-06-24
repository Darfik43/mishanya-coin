package com.darfik.mishanyacoin.service;

import com.darfik.mishanyacoin.model.User;
import com.darfik.mishanyacoin.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public void createUser(User user) {
        userRepository.save(user);
    }

}
