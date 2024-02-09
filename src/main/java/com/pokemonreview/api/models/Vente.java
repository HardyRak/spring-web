package com.pokemonreview.api.models;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Date;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vente")
public class Vente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idvente")
    Long idVente;
    @Column(name ="idannonce")
    String idAnnonce;
    @Column(name="idutilisateur")
    String idutilisateur;
    @Column(name="prix")
    double prix;
    @Column(name ="datevente")
    Date dateVente;
}