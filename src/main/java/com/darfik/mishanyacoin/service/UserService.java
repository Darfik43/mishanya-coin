package com.darfik.mishanyacoin.service;

import com.darfik.mishanyacoin.dto.RegistrationRequest;
import com.darfik.mishanyacoin.dto.UserInfoResponse;

public interface UserService {

    void createUser(RegistrationRequest registrationRequest);

    //TODO must return dto
    UserInfoResponse getById(String id);

}
