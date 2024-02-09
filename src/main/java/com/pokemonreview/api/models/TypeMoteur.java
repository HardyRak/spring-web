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

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "typemoteur")
public class TypeMoteur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idtype")
    private long idType;
    private String type;
}