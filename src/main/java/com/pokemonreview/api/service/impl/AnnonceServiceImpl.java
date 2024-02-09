package com.pokemonreview.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemonreview.api.models.Annonce;
import com.pokemonreview.api.repository.AnnonceRepository;
import com.pokemonreview.api.service.AnnonceService;

import java.util.List;
import java.util.Optional;


@Service
public class AnnonceServiceImpl implements AnnonceService{
    @Autowired
    private final AnnonceRepository annonceRepository;

    @Autowired
    public AnnonceServiceImpl(AnnonceRepository annonceRepository) {
        this.annonceRepository = annonceRepository;
    }

    @Override
    public List<Annonce> findAll(){
        return annonceRepository.findAll();
    }

    @Override
    public Annonce saveAnnonce(Annonce annonce){
        return annonceRepository.save(annonce);
    }

    @Override 
    public void deleteAnnonce(String idAnnonce){
        annonceRepository.deleteById(idAnnonce);
    }

    @Override
    public List<Annonce> findByIdUser(String idUser){
        return annonceRepository.findAnnonceByProprietaireId(idUser);
    }

    @Override
    public Annonce findByIdproprietaird(String proprieteId) {
        return annonceRepository.findByProprietaireId(proprieteId);
    }
    @Override
    public  List<Annonce>  findByStatut(String statut) {
        return annonceRepository.findAnnonceByStatut(statut);
    }
    @Override
    public  List<Annonce>  findByCategorieId(String CategorieId) {
        return annonceRepository.findAnnonceByCategorieId(CategorieId);
    }
    @Override
    public  List<Annonce>  findByMarqueId(String MarqueId) {
        return annonceRepository.findAnnonceByMarqueId(MarqueId);
    }
    @Override
    public  List<Annonce>  findByTypeMoteurId(String TypeMoteurId) {
        return annonceRepository.findAnnonceByTypeMoteurId(TypeMoteurId);
    }
    @Override
    public  List<Annonce>  findByNombrePlace(String NombrePlace) {
        return annonceRepository.findAnnonceByNombrePlace(NombrePlace);
    }
    @Override
    public  List<Annonce>  findByNombrePorte(String NombrePorte) {
        return annonceRepository.findAnnonceByNombrePorte(NombrePorte);
    }

    @Override
    public Optional<Annonce> findById(String id) {
        return annonceRepository.findById(id);

    }
    public List<Annonce> findByIntervalAnnee(String startYear, String endYear) {
        return annonceRepository.findByAnneeBetween(startYear, endYear);
    }
    public List<Annonce> findByIntervalPrix(String maxPrix, String minPrix) {
        return annonceRepository.findByPrixBetween(maxPrix, minPrix);
    }

}
