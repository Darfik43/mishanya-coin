package com.darfik.mishanyacoin.service;

import com.darfik.mishanyacoin.model.Coin;

public interface CoinService {

    void createCoin(String name, Double price);

    Coin getCoinInfo(String name);

    void updateCoinPrice(String name, Double price);

}
