package com.pokemonreview.api.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;

import com.pokemonreview.api.models.Annonce;
import com.pokemonreview.api.models.Favoris;
import com.pokemonreview.api.service.FavorisService;

import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/favoris")
@CrossOrigin(origins = "*")
@Service
public class FavorisController {

    @Autowired
    private FavorisService favorisService;

    @PostMapping("/save")
    @CrossOrigin(origins = "*")
    public Favoris saveFavoris(@RequestBody Favoris favoris) {
        return favorisService.saveFavory(favoris);
    }

    @GetMapping("/all")
    @CrossOrigin(origins = "*")
    public List<Favoris> findAll() {
        return favorisService.getAllFavoris();
    }

    @GetMapping("/utilisateur/{userId}")
    @CrossOrigin(origins = "*")
    public List<Favoris> findFavorisByUserId(@PathVariable String userId) {
        return favorisService.findFavorisByUserId(userId);
    }
    
    @PostMapping("/{userId}/annonces/{annonceId}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> ajouterAnnonceAuxFavoris(
            @PathVariable("userId") String userId,
            @PathVariable("annonceId") String annonceId
    ) {
        favorisService.ajouterAnnonceAuxFavoris(userId, annonceId);
        return ResponseEntity.ok("Annonce ajoutée aux favoris avec succès");
    }

    @GetMapping("/{username}")
    @CrossOrigin(origins = "*")
    public List<Annonce> getAnnoncesFavoritesByUsername(@PathVariable String username) {
        System.out.println(username);
        return favorisService.getAnnoncesFavoritesByUsername(username);
    }
    @DeleteMapping("/{username}/annonces/{annonceId}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> supprimerAnnonceDesFavoris(
            @PathVariable("username") String username,
            @PathVariable("annonceId") String annonceId
    ) {
        favorisService.supprimerAnnonceDesFavoris(username, annonceId);
        return ResponseEntity.ok("Annonce supprimée des favoris avec succès");
    }

}
