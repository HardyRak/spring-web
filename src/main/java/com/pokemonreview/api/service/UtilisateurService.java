package com.pokemonreview.api.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemonreview.api.models.UserEntity;
import com.pokemonreview.api.repository.UserRepository;

@Service
public class UtilisateurService {
    private final UserRepository utilisateurRepository;

    @Autowired
    public UtilisateurService(UserRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public UserEntity sauvegarderUtilisateur(UserEntity utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public UserEntity getUtilisateurById(String id) {
        Optional<UserEntity> optionalUtilisateur = utilisateurRepository.findById(id);
        return optionalUtilisateur.orElse(null);
    }
      public UserEntity FindByMailAndMotDePasse(String mail,String password) {
       return utilisateurRepository.findByMailAndPassword(mail, password);
    }


    public List<UserEntity> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public UserEntity updateUtilisateur(String id, UserEntity utilisateur) {
        Optional<UserEntity> optionalUtilisateur = utilisateurRepository.findById(id);
        if (optionalUtilisateur.isPresent()) {
            UserEntity existingUtilisateur = optionalUtilisateur.get();
            existingUtilisateur.setUsername(utilisateur.getUsername());
            existingUtilisateur.setPrenoms(utilisateur.getPrenoms());
            existingUtilisateur.setDateNaissance(utilisateur.getDateNaissance());
            existingUtilisateur.setGenre(utilisateur.getGenre());
            existingUtilisateur.setNationalite(utilisateur.getNationalite());
            existingUtilisateur.setMail(utilisateur.getMail());
        //    existingUtilisateur.setMotDePasse(utilisateur.getMotDePasse());
        //    existingUtilisateur.setAdmin(utilisateur.isAdmin());

            return utilisateurRepository.save(existingUtilisateur);
        }
        return null;
    }

    public void deleteUtilisateur(String id) {
        utilisateurRepository.deleteById(id);
    }
    public int getUserStatut(String mail) {
        Optional<UserEntity> userOptional = utilisateurRepository.findByMail(mail);
        if (userOptional.isPresent()) {
            UserEntity user = userOptional.get();
            return user.getStatut();
        }
        return -1; // Valeur par défaut si l'utilisateur n'est pas trouvé
    }
}
