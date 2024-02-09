package com.pokemonreview.api.models.mapper;

import com.pokemonreview.api.dto.MarqueDto;
import com.pokemonreview.api.models.Marque;

public class MarqueMapper {
    public static MarqueDto mapToMarqueDto(Marque marque){
        return new MarqueDto(
            marque.getId(),
            marque.getNom()
        
        );
    }
     public static Marque mapToMarque(MarqueDto marqueDto){
        return new Marque(
            marqueDto.getId(),
            marqueDto.getNom()
         
        );
    }
}