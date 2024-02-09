package com.pokemonreview.api.service;
import java.util.List;

import com.pokemonreview.api.models.Annonce;
import com.pokemonreview.api.models.Favoris;

public interface FavorisService{
    Favoris saveFavory(Favoris favoris);
    List<Favoris> getAllFavoris();
    List<Favoris> findFavorisByUserId(String userId);
    void ajouterAnnonceAuxFavoris(String userId, String annonceId);
    List<Annonce> getAnnoncesFavoritesByUsername(String username);
    void supprimerAnnonceDesFavoris(String username, String annonceId) ;
}