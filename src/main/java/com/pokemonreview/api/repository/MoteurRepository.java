package com.pokemonreview.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.pokemonreview.api.models.TypeMoteur;

@RepositoryRestResource
public interface MoteurRepository extends JpaRepository<TypeMoteur, Long> {
    
}
