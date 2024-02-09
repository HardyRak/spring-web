package com.pokemonreview.api.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pokemonreview.api.models.Genre;
import com.pokemonreview.api.repository.GenreRepo;

@RestController
@RequestMapping("/api/public/genre")
@CrossOrigin(origins = "*")
public class GenreController {
    
    @Autowired
    private GenreRepo genreRepo;

    @GetMapping
    @CrossOrigin(origins = "*")
    public List<Genre> getGenreAll() {
       return genreRepo.findAll();
      }
}
