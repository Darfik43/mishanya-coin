package com.darfik.mishanyacoin.controller;

import com.darfik.mishanyacoin.dto.CoinInfo;
import com.darfik.mishanyacoin.service.CoinService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coin")
@AllArgsConstructor
public class CoinController {

    private final CoinService coinService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCoin(@RequestBody CoinInfo coinInfo) {
        coinService.createCoin(coinInfo);
    }

}
