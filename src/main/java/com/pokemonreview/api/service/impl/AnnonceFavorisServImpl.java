package com.pokemonreview.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pokemonreview.api.repository.AnnonceFavorisRepo;
@Service
public class AnnonceFavorisServImpl{
    @Autowired
    private final AnnonceFavorisRepo AnnonceFavorisRepo;

    @Autowired
    public AnnonceFavorisServImpl(AnnonceFavorisRepo AnnonceFavorisRepo) {
        this.AnnonceFavorisRepo = AnnonceFavorisRepo;
    }
    
}
