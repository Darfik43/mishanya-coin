package com.darfik.mishanyacoin.service;

import com.darfik.mishanyacoin.dto.CoinInfo;
import com.darfik.mishanyacoin.exception.CoinAlreadyExistsException;
import com.darfik.mishanyacoin.model.Coin;
import com.darfik.mishanyacoin.repository.CoinRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class CoinServiceImpl implements CoinService {

    private final CoinRepository coinRepository;

    @Override
    public void createCoin(CoinInfo coinInfo) {
        if (!coinRepository.existsById(coinInfo.id())) {
            coinRepository.save(new Coin(coinInfo.id(), coinInfo.price()));
        } else {
            throw new CoinAlreadyExistsException("Coin with id " + coinInfo.id() + " already exists");
        }
    }

    @Override
    public CoinInfo getCoinInfo(String id) {
        Coin coin = coinRepository
                .findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("No coin with name " + id + " was found"));

        return new CoinInfo(coin.getId(), coin.getPrice());
    }

    @Override
    public void updateCoinPrice(CoinInfo coinInfo) {
        coinRepository.findById(coinInfo.id())
                .map(coin -> {
                    coin.setPrice(coinInfo.price());
                    return coin;
                })
                .orElseThrow(() -> new NoSuchElementException("No coin with name " + coinInfo.id() + " was found"));
    }

}
