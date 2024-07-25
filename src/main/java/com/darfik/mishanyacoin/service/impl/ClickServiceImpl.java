package com.darfik.mishanyacoin.service.impl;

import com.darfik.mishanyacoin.model.Click;
import com.darfik.mishanyacoin.repository.ClickRepository;
import com.darfik.mishanyacoin.service.ClickService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ClickServiceImpl implements ClickService {

    private final ClickRepository clickRepository;

    @Override
    public void handleClick(String id) {
        clickRepository.findById(id)
                .map(click -> {
                    click.setClicksAmount(click.getClicksAmount() + 1);
                    clickRepository.save(click);
                    return click;
                })
                .orElseThrow(() -> new NoSuchElementException("User with id " + id + " doesn't exist"));
    }

    @Override
    public Long getClicksAmount(String id) {
        return clickRepository.findById(id)
                .map(Click::getClicksAmount)
                .orElseThrow(() -> new NoSuchElementException("User with id " + id + " doesn't exist"));
    }
}
