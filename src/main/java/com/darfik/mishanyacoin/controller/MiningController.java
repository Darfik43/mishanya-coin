package com.darfik.mishanyacoin.controller;

import com.darfik.mishanyacoin.service.ClickService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mine")
@AllArgsConstructor
public class MiningController {

    private final ClickService clickService;

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public void mineCoin(@RequestBody String id) {
        clickService.handleClick(id);
    }



}
