package com.darfik.mishanyacoin.service;

import com.darfik.mishanyacoin.repository.ClickRepository;
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

}
