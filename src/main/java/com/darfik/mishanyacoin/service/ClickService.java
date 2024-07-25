package com.darfik.mishanyacoin.service;

public interface ClickService {

    void handleClick(String id);

    Long getClicksAmount(String id);

}
