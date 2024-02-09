package com.pokemonreview.api.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokemonreview.api.models.Categorie;
import com.pokemonreview.api.service.CategorieService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/categorie")
@CrossOrigin(origins = "*")
@Service 
public class CategorieControlleur {
    @Autowired
    private CategorieService categorieService;

    @GetMapping("/all")
    @CrossOrigin(origins = "*")
    public List<Categorie> findAll(){
        return categorieService.findAll();
    }

    @GetMapping("{id}")
    @CrossOrigin(origins = "*")
    public Categorie findById(@PathVariable Long id){
        return categorieService.findByIdCategory(id);
    }

    @PostMapping("/save")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Categorie> saveAsCategoriy(@RequestBody Categorie categorie){
        Categorie categories = categorieService.save(categorie);
        return new ResponseEntity<>(categories, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> deleteCategorie(@PathVariable Long id) {
        categorieService.deleteCategorie(id);
        return new ResponseEntity<>("Categorie supprimée avec succès", HttpStatus.OK);
    }

}
