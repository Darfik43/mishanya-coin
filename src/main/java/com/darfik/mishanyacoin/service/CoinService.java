package com.darfik.mishanyacoin.service;

import com.darfik.mishanyacoin.dto.CoinInfo;

public interface CoinService {

    void createCoin(CoinInfo coinInfo);

    CoinInfo getCoinInfo(String id);

    void updateCoinPrice(CoinInfo coinInfo);

}
