package com.darfik.mishanyacoin.model;

import jakarta.persistence.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("User")
public class User {

    @Id
    private Long id;

    private String username;

}
