package com.pokemonreview.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pokemonreview.api.models.Favoris;

import java.util.List;

public interface FavorisRepository extends MongoRepository<Favoris, String> {
    List<Favoris> findByIdUtilisateur(String idUtilisateur);

    Favoris findByidUtilisateur(String userId);
}
