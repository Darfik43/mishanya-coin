package com.darfik.mishanyacoin.service;

import com.darfik.mishanyacoin.dto.RegistrationRequest;
import com.darfik.mishanyacoin.dto.UserInfo;

public interface UserService {

    void createUser(RegistrationRequest registrationRequest);

    //TODO must return dto
    UserInfo getById(String id);

}
