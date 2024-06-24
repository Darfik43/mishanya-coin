package com.darfik.mishanyacoin.model;

import jakarta.persistence.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("User")
public class User implements Serializable {

    @Id
    private String id;

    private String username;

}
