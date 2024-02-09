package com.pokemonreview.api.controllers;

import java.util.List;



import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pokemonreview.api.service.BoiteNotificationService;

@RestController
@RequestMapping("/api/boitNotif")
@CrossOrigin(origins = "*")

public class BoiteNotificationControlleur {
    private final BoiteNotificationService boiteNotifService;

 @Autowired
    public BoiteNotificationControlleur(BoiteNotificationService boiteNotifService) {
        this.boiteNotifService = boiteNotifService;
    }
   

}
