package com.darfik.mishanyacoin.service.impl;

import com.darfik.mishanyacoin.dto.BalanceInfo;
import com.darfik.mishanyacoin.dto.CoinInfo;
import com.darfik.mishanyacoin.service.BalanceService;
import com.darfik.mishanyacoin.service.ClickService;
import com.darfik.mishanyacoin.service.CoinService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BalanceServiceImpl implements BalanceService {

    private final CoinService coinService;
    private final ClickService clickService;


    @Override
    public BalanceInfo getUserBalance(String id) {
        CoinInfo coinInfo = coinService.getCoinInfo("mishanya-coin"); // hardcoded the only one coin
        Long clicksAmount = clickService.getClicksAmount(id);

        return new BalanceInfo(clicksAmount, clicksAmount * coinInfo.price());
    }
}
