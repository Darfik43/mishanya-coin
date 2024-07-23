package com.darfik.mishanyacoin.service;

import com.darfik.mishanyacoin.dto.UserInfo;
import com.darfik.mishanyacoin.model.Click;
import com.darfik.mishanyacoin.repository.ClickRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClickServiceImpl implements ClickService {

    private final ClickRepository clickRepository;

    @Override
    public void handleClick(UserInfo userInfo) {
        Click click = clickRepository.findById(userInfo.id()).get(); //TODO Add check if user exists

        Long clickAmount = click.getClicksAmount();
        click.setClicksAmount(++clickAmount);

        clickRepository.save(click);
    }

}
