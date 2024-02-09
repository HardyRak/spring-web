package com.pokemonreview.api.service.impl;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;

import com.pokemonreview.api.models.TypeMoteur;
import com.pokemonreview.api.repository.MoteurRepository;
import com.pokemonreview.api.service.MoteurService;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
@Service
@AllArgsConstructor
public class MoteurServiceImpl implements MoteurService {
    @Autowired
    private MoteurRepository moteurRepository;

    @Override
    public List<TypeMoteur> findAll(){
        return moteurRepository.findAll();
    }
    
    @Override
    public TypeMoteur findByIdMoteur(Long id) {
        return moteurRepository.findById(id).orElse(null);
    }

    @Override
    public TypeMoteur save(TypeMoteur moteur){
        return moteurRepository.save(moteur);
    }

    @Override
    public void deleteMoteur(Long id){
        moteurRepository.deleteById(id);
    }

}