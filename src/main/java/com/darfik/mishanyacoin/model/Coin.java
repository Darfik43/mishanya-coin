package com.darfik.mishanyacoin.model;


import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("coin_price")
@AllArgsConstructor
public class Coin {

    private String name;

    private Double price;

}
