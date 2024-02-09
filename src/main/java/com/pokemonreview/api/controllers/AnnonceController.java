package com.pokemonreview.api.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;

import com.pokemonreview.api.models.Annonce;
import com.pokemonreview.api.service.AnnonceService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@RestController
@RequestMapping("/api/annonce")
@CrossOrigin(origins = "*")
@Service
public class AnnonceController {

    @Autowired
    private AnnonceService annonceService;

    @PostMapping("/save")
    @CrossOrigin(origins = "*")
    public Annonce saveAnnonce(@RequestBody Annonce Annonce) {
        return annonceService.saveAnnonce(Annonce);
    }

    @GetMapping("/all")
    @CrossOrigin(origins = "*")
    public List<Annonce> findAll() {
        return annonceService.findAll();
    }
    @GetMapping("/allconfirmer")
@CrossOrigin(origins = "*")
public List<Annonce> findAllConfirmer() {
    List<Annonce> annonces = annonceService.findAll();
    List<Annonce> annoncesAvecStatutZero = annonces.stream()
            .filter(annonce -> annonce.getStatut().equals("1"))
            .collect(Collectors.toList());
    return annoncesAvecStatutZero;
}

    @GetMapping("/allnonconfirmer")
    @CrossOrigin(origins = "*")
    public List<Annonce> findAllnonnConfirmer() {
    List<Annonce> annonces = annonceService.findAll();
    List<Annonce> annoncesAvecStatutZero = annonces.stream()
            .filter(annonce -> annonce.getStatut().equals("0"))
            .collect(Collectors.toList());
    return annoncesAvecStatutZero;
}
@PutMapping("/{id}/passerStatutDe0A1")
@CrossOrigin(origins = "*")
public ResponseEntity<String> passerStatutDe0A1(@PathVariable String id) {
    try {
        Optional<Annonce> annonceOptional = annonceService.findById(id);
        if (!annonceOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Annonce non trouvée");
        }
        Annonce annonce = annonceOptional.get();
        annonce.setStatut("1"); // Mettre à jour le statut de 0 à 1
        annonceService.saveAnnonce(annonce); // Enregistrer la mise à jour dans la base de données
        return ResponseEntity.ok("Statut de l'annonce mis à jour avec succès");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la mise à jour du statut de l'annonce");
    }
}

@PutMapping("/{id}/passerStatutDe1A0")
@CrossOrigin(origins = "*")
public ResponseEntity<String> passerStatutDe1A0(@PathVariable String id) {
    try {
        Optional<Annonce> annonceOptional = annonceService.findById(id);
        if (!annonceOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Annonce non trouvée");
        }
        Annonce annonce = annonceOptional.get();
        annonce.setStatut("0"); // Mettre à jour le statut de 1 à 0
        annonceService.saveAnnonce(annonce); // Enregistrer la mise à jour dans la base de données
        return ResponseEntity.ok("Statut de l'annonce mis à jour avec succès");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la mise à jour du statut de l'annonce");
    }
}
    @DeleteMapping("delete/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> deleteAnnonce(@PathVariable String id) {
        annonceService.deleteAnnonce(id);
        return new ResponseEntity<>("Annonce supprimée avec succès", HttpStatus.OK);
    }

    @GetMapping("proprietaire/{id}")
    @CrossOrigin(origins = "*")
    public List<Annonce> findByIdProprietaire(@PathVariable String id){
        return annonceService.findByIdUser(id);
    }
    @GetMapping("proprietaire/statut/{statut}")
    @CrossOrigin(origins = "*")
    public List<Annonce> findByStatut(@PathVariable String statut){
        return annonceService.findByStatut(statut);
    }
    @GetMapping("proprietaire/categorie/{CategorieId}")
    @CrossOrigin(origins = "*")
    public List<Annonce> findByCategorie(@PathVariable String CategorieId){
        return annonceService.findByCategorieId(CategorieId);
    }
    @GetMapping("proprietaire/marque/{MarqueId}")
    @CrossOrigin(origins = "*")
    public List<Annonce> findByMarqueId(@PathVariable String MarqueId){
        return annonceService.findByMarqueId(MarqueId);
    }
    @GetMapping("proprietaire/moteur/{TypeMoteurId}")
    @CrossOrigin(origins = "*")
    public List<Annonce> findByTypeMoteurId(@PathVariable String TypeMoteurId){
        return annonceService.findByTypeMoteurId(TypeMoteurId);
    }
    @GetMapping("proprietaire/place/{NombrePlace}")
    @CrossOrigin(origins = "*")
    public List<Annonce> findByNombrePlace(@PathVariable String NombrePlace){
        return annonceService.findByNombrePlace(NombrePlace);
    }
    @GetMapping("proprietaire/porte/{NombrePorte}")
    @CrossOrigin(origins = "*")
    public List<Annonce> findByNombrePorte(@PathVariable String NombrePorte){
        return annonceService.findByNombrePorte(NombrePorte);
    }
    @GetMapping("/{id}")
@CrossOrigin(origins = "*")
public List<Annonce> findById(@PathVariable String id) {
    List<Annonce> annonces = annonceService.findByIdUser(id);
    return annonces;
}
@PutMapping("/update/{proprietaireId}")
@CrossOrigin(origins = "*")
public ResponseEntity<String> updateAnnonce(@PathVariable String proprietaireId, @RequestBody Annonce updatedAnnonce) {
    Annonce existingAnnonce = annonceService.findByIdproprietaird(proprietaireId);

    if (existingAnnonce != null) {
        existingAnnonce.setProprietaireId(updatedAnnonce.getProprietaireId());
        existingAnnonce.setCategorieId(updatedAnnonce.getCategorieId());
        existingAnnonce.setMarqueId(updatedAnnonce.getMarqueId());
        existingAnnonce.setModele(updatedAnnonce.getModele());
        existingAnnonce.setTypeMoteurId(updatedAnnonce.getTypeMoteurId());
        existingAnnonce.setConsommation(updatedAnnonce.getConsommation());
        existingAnnonce.setNombrePlace(updatedAnnonce.getNombrePlace());
        existingAnnonce.setNombrePorte(updatedAnnonce.getNombrePorte());
        existingAnnonce.setAnnee(updatedAnnonce.getAnnee());
        existingAnnonce.setKilometrage(updatedAnnonce.getKilometrage());
        existingAnnonce.setProvenanceId(updatedAnnonce.getProvenanceId());
        existingAnnonce.setPrix(updatedAnnonce.getPrix());
        existingAnnonce.setStatut(updatedAnnonce.getStatut());
        existingAnnonce.setDateAnnonce(updatedAnnonce.getDateAnnonce());
        existingAnnonce.setImages(updatedAnnonce.getImages());

        annonceService.saveAnnonce(existingAnnonce);
        return new ResponseEntity<>("Annonce mise à jour avec succès", HttpStatus.OK);
    } else {
        return new ResponseEntity<>("Annonce non trouvée", HttpStatus.NOT_FOUND);
    }
}

@GetMapping("/date/{startYear}/{endYear}")
@CrossOrigin(origins = "*")
public List<Annonce> findByIntervalAnnee(@PathVariable String startYear, @PathVariable String endYear) {
    System.out.println(endYear);
    return annonceService.findByIntervalAnnee(startYear, endYear);
}
@GetMapping("/prix/{maxPrix}/{minPrix}")
@CrossOrigin(origins = "*")
public List<Annonce> findByIntervalPrix(@PathVariable String maxPrix, @PathVariable String minPrix) {
    System.out.println(minPrix);
    return annonceService.findByIntervalPrix(maxPrix, minPrix);
}
}

