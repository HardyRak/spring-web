package com.pokemonreview.api.controllers;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pokemonreview.api.models.UserEntity;
import com.pokemonreview.api.service.UtilisateurService;

@RestController
@RequestMapping("/api/utilisateurs")
@CrossOrigin(origins = "*")

public class UtilisateurController {
    private final UtilisateurService utilisateurService;

    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @PostMapping
    @CrossOrigin(origins = "*")
    public UserEntity createUtilisateur(@RequestBody UserEntity utilisateur) {
        return utilisateurService.sauvegarderUtilisateur(utilisateur);
    }

    @GetMapping
    @CrossOrigin(origins = "*")
    public List<UserEntity> getUtilisateurAll() {
        return utilisateurService.getAllUtilisateurs();
    }

    @GetMapping("/{mail}/{password}")
    @CrossOrigin(origins = "*")
    public UserEntity findByMailAndMotDePasse(@PathVariable String mail, @PathVariable String password) {
        return utilisateurService.FindByMailAndMotDePasse(mail, password);
    }
        @GetMapping("/{mail}")
    @CrossOrigin(origins = "*")
    public  Optional<UserEntity> findByMail(@PathVariable String mail) {
        return utilisateurService.FindByMail(mail);
    }

    @GetMapping("{id}")
    @CrossOrigin(origins = "*")
    public UserEntity getUtilisateurById(@PathVariable("id") String id) {
        return utilisateurService.getUtilisateurById(id);
    }

    @PutMapping("{id}")
    @CrossOrigin(origins = "*")
    public UserEntity updateUtilisateur(@PathVariable("id") String id, @RequestBody UserEntity utilisateur) {
        return utilisateurService.updateUtilisateur(id, utilisateur);
    }

    @DeleteMapping("{id}")
    @CrossOrigin(origins = "*")
    public void deleteUtilisateur(@PathVariable("id") String id) {
        utilisateurService.deleteUtilisateur(id);
    }
    @GetMapping("/{mail}/statut")
    public int getUserStatut(@PathVariable String mail) {
        return utilisateurService.getUserStatut(mail);
    }
}
