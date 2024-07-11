package com.darfik.mishanyacoin.service;

import com.darfik.mishanyacoin.model.Coin;

public interface CoinService {

    void createCoin(String name, Double price);

    //TODO must return dto
    Coin getCoinInfo(String name);

    void updateCoinPrice(String name, Double price);

}
