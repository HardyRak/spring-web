package com.pokemonreview.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pokemonreview.api.models.Vente;

import java.sql.Date;
public interface VenteService {
    List<Vente> findAll() ;
    Vente findByIdVente(Long id);
    Vente save(Vente vente);
    List<Vente> findByIdUtilisateur(String idUtilisateur);
    List<Vente> findByDateVente(Date dateVente);
}