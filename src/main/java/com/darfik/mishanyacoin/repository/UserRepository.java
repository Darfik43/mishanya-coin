package com.darfik.mishanyacoin.repository;

import com.darfik.mishanyacoin.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
}
