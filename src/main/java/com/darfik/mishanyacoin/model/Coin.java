package com.darfik.mishanyacoin.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("coin_price")
@AllArgsConstructor
public class Coin {

    @JsonProperty
    private String id;  //Should be name of coin

    @JsonProperty
    private Double price;

}
