package com.pokemonreview.api.models.mapper;

import com.pokemonreview.api.dto.PaysDto;
import com.pokemonreview.api.models.Pays;

public class PaysMapper {
    public static PaysDto mapToPaysDto(Pays pays){
        return new PaysDto(
            pays.getId(),
            pays.getNom()
        );
    }
     public static Pays mapToPays(PaysDto paysDto){
        return new Pays(
            paysDto.getId(),
            paysDto.getNom()
       
        );
    }
}
