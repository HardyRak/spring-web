package com.pokemonreview.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pokemonreview.api.models.Notification;

public interface NotificationRepo extends MongoRepository<Notification, String>{
    
}
