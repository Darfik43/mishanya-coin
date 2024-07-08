package com.darfik.mishanyacoin.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("User")
@AllArgsConstructor
public class User implements Serializable {

    @JsonProperty
    private String id;

    @JsonProperty
    private String username;

}
