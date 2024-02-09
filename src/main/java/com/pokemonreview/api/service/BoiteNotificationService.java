package com.pokemonreview.api.service;

import java.util.List;
import java.util.Optional;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemonreview.api.repository.BoiteNotificationRepo;

@Service
public class BoiteNotificationService {
    private final BoiteNotificationRepo boiteNotifRepo;

    @Autowired
    public BoiteNotificationService(BoiteNotificationRepo boiteNotifRepo) {
        this.boiteNotifRepo = boiteNotifRepo;
    }

  
}
