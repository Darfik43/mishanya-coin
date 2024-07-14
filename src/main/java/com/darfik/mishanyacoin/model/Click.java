package com.darfik.mishanyacoin.model;

import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("user_clicks")
@AllArgsConstructor
public class Click {

    private String userId;

    private Long clicksAmount;

}
