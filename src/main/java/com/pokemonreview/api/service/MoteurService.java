package com.pokemonreview.api.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.pokemonreview.api.models.TypeMoteur;

public interface MoteurService {
    List<TypeMoteur> findAll();
    TypeMoteur findByIdMoteur(Long id);
    TypeMoteur save(TypeMoteur moteur);
    void deleteMoteur(Long id);
}