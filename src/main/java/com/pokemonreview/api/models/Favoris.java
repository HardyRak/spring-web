package com.pokemonreview.api.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "favoris")
public class Favoris{
    @Id
    private String idFavoris;
    private String idUtilisateur;
    private List<AnnonceFavoris> annonceFavoris;
}