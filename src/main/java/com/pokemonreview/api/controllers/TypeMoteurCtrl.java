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

import com.pokemonreview.api.models.TypeMoteur;
import com.pokemonreview.api.service.MoteurService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/moteur")
@CrossOrigin(origins = "*")
@Service
public class TypeMoteurCtrl{
    @Autowired
    MoteurService moteurService;

    @GetMapping("/all")
    @CrossOrigin(origins = "*")
    public List<TypeMoteur> findAll(){
        return moteurService.findAll();
    }

    @GetMapping("{id}")
    @CrossOrigin(origins = "*")
    public TypeMoteur findById(@PathVariable Long id){
        return moteurService.findByIdMoteur(id);
    }

    @PostMapping("/save")
    @CrossOrigin(origins = "*")
    public ResponseEntity<TypeMoteur> saveAsTypeMoteur(@RequestBody TypeMoteur moteur){
        TypeMoteur moteurs = moteurService.save(moteur);
        return new ResponseEntity<>(moteurs, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> deleteMoteur(@PathVariable Long id) {
        moteurService.deleteMoteur(id);
        return new ResponseEntity<>("Moteur supprimée avec succès", HttpStatus.OK);
    }

}
