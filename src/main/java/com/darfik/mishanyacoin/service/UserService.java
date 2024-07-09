package com.darfik.mishanyacoin.service;

import com.darfik.mishanyacoin.dto.RegistrationRequest;
import com.darfik.mishanyacoin.model.User;

public interface UserService {

    void createUser(RegistrationRequest registrationRequest);

    //TODO must return dto
    User getById(String id);

}
