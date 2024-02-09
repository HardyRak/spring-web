
package com.pokemonreview.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;

import com.pokemonreview.api.models.Categorie;
import com.pokemonreview.api.repository.CategorieRepository;
import com.pokemonreview.api.service.CategorieService;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
@Service
@AllArgsConstructor
public class CategorieServiceImpl implements CategorieService {
    @Autowired
    private CategorieRepository categorieRepository;

    @Override
    public List<Categorie> findAll(){
        return categorieRepository.findAll();
    }
    
    @Override
    public Categorie findByIdCategory(Long id) {
        return categorieRepository.findById(id).orElse(null);
    }

    @Override
    public Categorie save(Categorie categorie){
        return categorieRepository.save(categorie);
    }

    @Override
    public void deleteCategorie(Long id){
        categorieRepository.deleteById(id);
    }

}