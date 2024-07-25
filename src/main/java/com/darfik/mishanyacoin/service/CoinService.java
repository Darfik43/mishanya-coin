package com.darfik.mishanyacoin.service;

import com.darfik.mishanyacoin.model.Coin;

public interface CoinService {

    void createCoin(String id, Double price);

    //TODO must return dto
    Coin getCoinInfo(String id);

    void updateCoinPrice(String id, Double price);

}
