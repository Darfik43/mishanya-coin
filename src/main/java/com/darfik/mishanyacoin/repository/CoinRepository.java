package com.darfik.mishanyacoin.repository;

import com.darfik.mishanyacoin.model.Coin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinRepository extends CrudRepository<Coin, String> {
}
