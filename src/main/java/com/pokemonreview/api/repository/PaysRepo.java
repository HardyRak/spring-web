package com.pokemonreview.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.pokemonreview.api.models.Pays;


@RepositoryRestResource
public interface PaysRepo extends JpaRepository<Pays, Long> {
    
}
