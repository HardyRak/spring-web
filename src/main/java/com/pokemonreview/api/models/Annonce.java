package com.pokemonreview.api.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;
import java.util.Date;
import java.util.List;


@Document(collection = "annonces")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Annonce {
    @Id
    private String id;
    private String proprietaireId;
    private String categorieId;
    private String marqueId;
    private String modele;
    private String typeMoteurId;
    private String consommation;
    private String nombrePlace;
    private String nombrePorte;
    private String annee;
    private String kilometrage;
    private String provenanceId;
    private String prix;
    private String statut;
    private Date dateAnnonce;
    private List<Images> images;

    

}