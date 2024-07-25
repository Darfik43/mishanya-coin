package com.darfik.mishanyacoin.controller;

import com.darfik.mishanyacoin.dto.BalanceInfo;
import com.darfik.mishanyacoin.service.BalanceService;
import com.darfik.mishanyacoin.service.ClickService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mine")
@AllArgsConstructor
public class MiningController {

    private final ClickService clickService;
    private final BalanceService balanceService;

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public void mineCoin(@RequestBody String id) {
        clickService.handleClick(id);
    }

    @GetMapping("/{id}")
    public BalanceInfo getUserBalance(@PathVariable String id) {
        return balanceService.getUserBalance(id);
    }

}
