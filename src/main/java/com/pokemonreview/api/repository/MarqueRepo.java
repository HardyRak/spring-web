package com.pokemonreview.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.pokemonreview.api.models.Marque;


@RepositoryRestResource
public interface MarqueRepo extends JpaRepository<Marque, Long> {
    
}
