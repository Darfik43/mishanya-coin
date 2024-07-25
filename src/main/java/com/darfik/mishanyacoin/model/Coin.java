package com.darfik.mishanyacoin.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("coin_price")
@AllArgsConstructor
@Getter
@Setter
public class Coin {

    @JsonProperty
    private String id;

    @JsonProperty
    private Double price;

}
