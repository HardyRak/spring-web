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

import com.pokemonreview.api.models.Vente;
import com.pokemonreview.api.service.VenteService;

import lombok.AllArgsConstructor;
import java.sql.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
@AllArgsConstructor
@RestController
@RequestMapping("/api/vente")
@CrossOrigin(origins = "*")
@Service
public class VenteControlleur {
    @Autowired
    private VenteService venteService;

    @GetMapping("/all")
    @CrossOrigin(origins = "*")
    public List<Vente> findAll(){
        return venteService.findAll();
    }

    @GetMapping("{id}")
    @CrossOrigin(origins = "*")
    public Vente findById(@PathVariable Long id){
        return venteService.findByIdVente(id);
    }

    @PostMapping("/save")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Vente> saveAsCategoriy(@RequestBody Vente vente){
        Vente ventes = venteService.save(vente);
        return new ResponseEntity<>(ventes, HttpStatus.CREATED);
    }

    @GetMapping("/utilisateur/{idutilisateur}")
    @CrossOrigin(origins = "*")
    public List<Vente> findByIdUtilisateur(@PathVariable String idutilisateur){
        return venteService.findByIdUtilisateur(idutilisateur);
    }

    @GetMapping("/date/{dateVente}")
    @CrossOrigin(origins = "*")
    public List<Vente> findByDateVente(@PathVariable String dateVente) throws Exception{
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsedDate = dateFormat.parse(dateVente);
        Date dateVentes=new Date(parsedDate.getTime());
        return venteService.findByDateVente(dateVentes);
    }
}
