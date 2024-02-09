package com.pokemonreview.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pokemonreview.api.models.Categorie;

public interface CategorieService {
    List<Categorie> findAll() ;
    Categorie findByIdCategory(Long id);
    Categorie save(Categorie categorie);
    void deleteCategorie(Long id);
}