package com.pokemonreview.api.repository;



import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pokemonreview.api.models.BoiteNotification;

public interface BoiteNotificationRepo extends MongoRepository<BoiteNotification, String> {

}
