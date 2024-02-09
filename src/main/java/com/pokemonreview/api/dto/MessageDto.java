package com.pokemonreview.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {
    private String expediteurId;
    private String proprietaireId;
    private String interlocuteurId;
    private String contenu;

}
