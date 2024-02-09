package com.pokemonreview.api.service.impl;


import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;

import com.pokemonreview.api.models.Vente;
import com.pokemonreview.api.repository.VenteRepository;
import com.pokemonreview.api.service.VenteService;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.Date;
@Service
@AllArgsConstructor
public class VenteServiceImpl implements VenteService {
    @Autowired
    private VenteRepository venteRepository;

    @Override
    public List<Vente> findAll(){
        return venteRepository.findAll();
    }
    
    @Override
    public Vente findByIdVente(Long id) {
        return venteRepository.findById(id).orElse(null);
    }

    @Override
    public Vente save(Vente vente){
        return venteRepository.save(vente);
    }

    @Override
    public List<Vente> findByIdUtilisateur(String idUtilisateur){
        return venteRepository.findByIdutilisateur(idUtilisateur);
    }

    @Override
    public List<Vente> findByDateVente(Date datevente){
        return venteRepository.findByDateVente(datevente);
    }
}