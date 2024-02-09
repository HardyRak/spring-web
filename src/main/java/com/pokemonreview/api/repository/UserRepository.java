package com.pokemonreview.api.repository;

import com.pokemonreview.api.models.UserEntity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends MongoRepository <UserEntity, String> {
    Optional<UserEntity> findByUsername(String username);
    Boolean existsByUsername(String username);
    UserEntity findByMailAndPassword(String mail, String password);
    Optional<UserEntity> findByMail(String username);

}
