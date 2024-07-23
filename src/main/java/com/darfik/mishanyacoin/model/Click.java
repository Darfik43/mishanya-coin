package com.darfik.mishanyacoin.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("user_clicks")
@AllArgsConstructor
@Getter
@Setter
public class Click {

    private String id;

    private Long clicksAmount;

}
