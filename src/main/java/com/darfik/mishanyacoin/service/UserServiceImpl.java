package com.darfik.mishanyacoin.service;

import com.darfik.mishanyacoin.dto.RegistrationRequest;
import com.darfik.mishanyacoin.dto.UserInfo;
import com.darfik.mishanyacoin.exception.UserAlreadyExistsException;
import com.darfik.mishanyacoin.model.Click;
import com.darfik.mishanyacoin.model.User;
import com.darfik.mishanyacoin.repository.ClickRepository;
import com.darfik.mishanyacoin.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ClickRepository clickRepository;

    @Override
    public void createUser(RegistrationRequest registrationRequest) {
        if (!userExists(registrationRequest.username())) {
            userRepository.save(new User(registrationRequest.username(), registrationRequest.username()));
            clickRepository.save(new Click(registrationRequest.username(), 0L));
        } else {
            throw new UserAlreadyExistsException(
                    "User with the nickname " + registrationRequest.username() + " already exists"
            );
        }
    }

    @Override
    public UserInfo getById(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("User " + id + " doesn't exist"));
        return new UserInfo(
                user.getId(),
                user.getUsername(),
                clickRepository.findById(id).get().getClicksAmount()
        ); // Костыль
    }

    private boolean userExists(String id) {
        return userRepository.existsById(id);
    }

}
