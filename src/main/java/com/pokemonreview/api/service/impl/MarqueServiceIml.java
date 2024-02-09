package com.pokemonreview.api.service.impl;


import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;

import com.pokemonreview.api.dto.MarqueDto;
import com.pokemonreview.api.models.Marque;
import com.pokemonreview.api.models.mapper.MarqueMapper;
import com.pokemonreview.api.repository.MarqueRepo;
import com.pokemonreview.api.service.MarqueService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MarqueServiceIml implements MarqueService {
    private MarqueRepo marqueRepo;
    @Override
    public MarqueDto createMarque(MarqueDto marqueDto){
        Marque marque = MarqueMapper.mapToMarque(marqueDto);
        Marque savedMarque= marqueRepo.save(marque);

        return MarqueMapper.mapToMarqueDto(savedMarque);
    }
    @Override
    public MarqueDto getMarqueById(Long marqueId) {
     Marque marque = marqueRepo.findById(marqueId)
        .orElseThrow();
    return MarqueMapper.mapToMarqueDto(marque);
    }
    @Override
    public List<MarqueDto> getAllMarque() {
        List<Marque>marques=marqueRepo.findAll();
        return marques.stream().map((marque) -> MarqueMapper.mapToMarqueDto(marque)) 
               .collect(Collectors.toList());
    }
    @Override
    public MarqueDto updateMarque(Long marqueId, MarqueDto updateMarque) {
     Marque marque= marqueRepo.findById(marqueId)
      .orElseThrow(
       );
        marque.setNom(updateMarque.getNom());
     
        Marque updateMarqueobj=marqueRepo.save(marque);
        return MarqueMapper.mapToMarqueDto(updateMarqueobj);

    }
    @Override
    public void deleteMarque(Long marqueId) {
      Marque marque=  marqueRepo.findById(marqueId)
      .orElseThrow(
       );   
      marqueRepo.deleteById(marqueId);
    }
}
