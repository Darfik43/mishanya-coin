package com.darfik.mishanyacoin.repository;

import com.darfik.mishanyacoin.model.Click;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClickRepository extends CrudRepository <Click, String> {
}
