package com.pokemonreview.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pokemonreview.api.models.AnnonceFavoris;

public interface AnnonceFavorisRepo extends MongoRepository<AnnonceFavoris, String> {
    
}
