package com.pokemonreview.api.service;
import java.util.List;
import java.util.Optional;

import com.pokemonreview.api.models.Annonce;

public interface AnnonceService{
    Annonce saveAnnonce(Annonce annonce);
    Optional<Annonce> findById(String id);
    List<Annonce> findAll();
    void deleteAnnonce(String idAnnonce);
    List<Annonce> findByIdUser(String idUser);
    Annonce findByIdproprietaird(String idUser);
    List<Annonce> findByStatut(String statut);
    List<Annonce>  findByCategorieId(String CategorieId);
    List<Annonce>  findByMarqueId(String MarqueId) ;
    List<Annonce>  findByTypeMoteurId(String TypeMoteurId);
    List<Annonce>  findByNombrePlace(String NombrePlace) ;
    List<Annonce>  findByNombrePorte(String NombrePorte) ;
    List<Annonce> findByIntervalAnnee(String startYear, String endYear) ;
    List<Annonce> findByIntervalPrix(String maxPrix, String minPrix) ;
}