package com.pokemonreview.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemonreview.api.models.Annonce;
import com.pokemonreview.api.models.AnnonceFavoris;
import com.pokemonreview.api.models.Favoris;
import com.pokemonreview.api.models.UserEntity;
import com.pokemonreview.api.repository.AnnonceRepository;
import com.pokemonreview.api.repository.FavorisRepository;
import com.pokemonreview.api.repository.UserRepository;
import com.pokemonreview.api.service.FavorisService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FavorisServiceImpl implements FavorisService{
    @Autowired
    private final FavorisRepository favorisRepository;
    private final AnnonceRepository annonceRepository;
    private final UserRepository utilisateurRepository ;


    @Autowired
    public FavorisServiceImpl(FavorisRepository favorisRepository, AnnonceRepository annonceRepository ,UserRepository utilisateurRepository ) {
        this.favorisRepository = favorisRepository;
        this.annonceRepository = annonceRepository;
        this.utilisateurRepository = utilisateurRepository;
    }
    @Override
    public Favoris saveFavory(Favoris favoris){
        return favorisRepository.save(favoris);
    }

    @Override
    public List<Favoris> getAllFavoris() {
        return favorisRepository.findAll();
    }

    @Override
    public List<Favoris> findFavorisByUserId(String userId){
        return favorisRepository.findByIdUtilisateur(userId);
    }
     public void ajouterAnnonceAuxFavoris(String userId, String annonceId) {
        Favoris favoris = favorisRepository.findByidUtilisateur(userId);
        if (favoris == null) {
            favoris = new Favoris();
            favoris.setIdUtilisateur(userId);
            favoris.setAnnonceFavoris(new ArrayList<>());
        }

        Annonce annonce = annonceRepository.findById(annonceId).orElse(null);
        if (annonce != null) {
            AnnonceFavoris nouvelleAnnonceFavoris = new AnnonceFavoris();
            nouvelleAnnonceFavoris.setIdAnnonces(annonceId);
            nouvelleAnnonceFavoris.setDateAjout(new Date());

            favoris.getAnnonceFavoris().add(nouvelleAnnonceFavoris);
            favorisRepository.save(favoris);
        } else {
            // Gérer le cas où l'annonce n'existe pas
        }
    }
    public List<Annonce> getAnnoncesFavoritesByUsername(String username) {
        System.out.println("Recherche de l'utilisateur par nom d'utilisateur : " + username);
    
        // Récupérer l'utilisateur à partir du nom d'utilisateur
        Optional<UserEntity> utilisateur = utilisateurRepository.findByMail(username);
    
        if (!utilisateur.isPresent()) {
            System.out.println("Utilisateur non trouvé");
            throw new IllegalArgumentException("Utilisateur non trouvé");
        }
    
        System.out.println("Utilisateur trouvé : " + utilisateur.get());
    
        // Récupérer les favoris de l'utilisateur
        List<Favoris> favoris = favorisRepository.findByIdUtilisateur(utilisateur.get().getMail());
        System.out.println("Nombre de favoris trouvés : " + favoris.size());
    
        List<Annonce> annoncesFavorites = new ArrayList<>();
    
        for (Favoris favori : favoris) {
            System.out.println("Recherche de l'annonce correspondant au favori : " + favori);
        
            for (AnnonceFavoris annonceFavoris : favori.getAnnonceFavoris()) {
                System.out.println("Id de l'annonce favoris : " + annonceFavoris.getIdAnnonces());
        
                // Récupérer l'annonce correspondante
                Optional<Annonce> annonceOptional = annonceRepository.findById(annonceFavoris.getIdAnnonces());
        
                annonceOptional.ifPresent(annonce -> {
                    annoncesFavorites.add(annonce);
                    System.out.println("Annonce ajoutée aux annonces favorites : " + annonce);
                });
            }
        }
    
        System.out.println("Annonces favorites récupérées : " + annoncesFavorites.size());
    
        return annoncesFavorites;
    }
    public void supprimerAnnonceDesFavoris(String username, String annonceId) {
        // Recherche de l'utilisateur par nom d'utilisateur
        Optional<UserEntity> utilisateur = utilisateurRepository.findByMail(username);
        
        if (!utilisateur.isPresent()) {
            throw new IllegalArgumentException("Utilisateur non trouvé");
        }
        
        // Récupération des favoris de l'utilisateur
        List<Favoris> favoris = favorisRepository.findByIdUtilisateur(utilisateur.get().getMail());
        
        for (Favoris favori : favoris) {
            // Recherche de l'annonce correspondant au favori
            List<AnnonceFavoris> annonceFavorisList = favori.getAnnonceFavoris();
            
            for (AnnonceFavoris annonceFavoris : new ArrayList<>(annonceFavorisList)) {
                if (annonceFavoris.getIdAnnonces().equals(annonceId)) {
                    // Suppression de l'annonce des favoris
                    annonceFavorisList.remove(annonceFavoris);
                    favorisRepository.save(favori);
                }
            }
        }
    }
    
}
