package com.pokemonreview.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pokemonreview.api.models.Annonce;

import java.util.List;
import java.util.Optional;

public interface AnnonceRepository extends MongoRepository<Annonce, String> {
    List<Annonce> findAnnonceByProprietaireId(String proprietaireId);
    List<Annonce> findAnnonceByStatut(String Statut);
    List<Annonce> findAnnonceByCategorieId(String categorieId);
    List<Annonce> findAnnonceByMarqueId(String marqueId);
    List<Annonce> findAnnonceByTypeMoteurId(String typeMoteurId);
    List<Annonce> findAnnonceByNombrePlace(String nombrePlace);
    List<Annonce> findAnnonceByNombrePorte(String nombrePorte);
    Optional<Annonce> findById(String id);
    Annonce findByProprietaireId(String proprietaireId);
    List<Annonce> findByAnneeBetween(String startYear, String endYear);
    List<Annonce> findByPrixBetween(String prixMax, String prixMin);



}
