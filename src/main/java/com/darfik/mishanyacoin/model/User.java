package com.darfik.mishanyacoin.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("user")
@Getter
@AllArgsConstructor
public class User implements Serializable {

    @JsonProperty
    private String id;

    @JsonProperty
    private String username;

}
