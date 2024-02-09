package com.pokemonreview.api.service;


import java.util.List;

import com.pokemonreview.api.dto.MarqueDto;


public interface MarqueService {
    MarqueDto createMarque(MarqueDto marqueDto);

    MarqueDto getMarqueById(Long marqueId );

    List<MarqueDto> getAllMarque() ;

    MarqueDto updateMarque(Long marqueId , MarqueDto updatedMarque);

    void deleteMarque(Long marqueId);
}
