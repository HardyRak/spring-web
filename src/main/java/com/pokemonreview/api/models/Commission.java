package com.pokemonreview.api.models;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;;
@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "commission")
public class Commission{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idcommission")
    Long idCommision;

    @ManyToOne
    @JoinColumn(name = "idvente", referencedColumnName = "idvente")
    private Vente vente;

    @ManyToOne
    @JoinColumn(name = "idparam", referencedColumnName = "id")
    private ParamCommission parametre;
    
    double montant;
    Date dateComission;
}