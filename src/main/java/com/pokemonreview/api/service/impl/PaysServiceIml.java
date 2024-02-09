package com.pokemonreview.api.service.impl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pokemonreview.api.dto.PaysDto;
import com.pokemonreview.api.exceptions.ResourceNotFoundException;
import com.pokemonreview.api.models.Pays;
import com.pokemonreview.api.models.mapper.PaysMapper;
import com.pokemonreview.api.repository.PaysRepo;
import com.pokemonreview.api.service.PaysService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PaysServiceIml implements PaysService {

    private PaysRepo paysRepo;

    @Override
    public PaysDto createPays(PaysDto paysDto) {
       Pays pays = PaysMapper.mapToPays(paysDto);
       Pays savedPays= paysRepo.save(pays);

       return PaysMapper.mapToPaysDto(savedPays);
    }

    @Override
    public PaysDto getPaysById(Long paysId) {
   Pays pays = paysRepo.findById(paysId)
        .orElseThrow(() -> 
        new ResourceNotFoundException("Pays avec cette id n'existe pas :"+ paysId));
    return PaysMapper.mapToPaysDto(pays);
    }

    @Override
    public List<PaysDto> getAllPays() {
        List<Pays>Pays=paysRepo.findAll();
        return Pays.stream().map((pays) -> PaysMapper.mapToPaysDto(pays)) 
               .collect(Collectors.toList());
    }

    @Override
    public PaysDto updatePays(Long paysId, PaysDto updatePays) {
      Pays pays = paysRepo.findById(paysId)
      .orElseThrow(() ->
       new ResourceNotFoundException("Pays avec cette id n'existe pas :"+ paysId)
       );
        pays.setNom(updatePays.getNom());
    
        Pays updatePaysobj=paysRepo.save(pays);
        return PaysMapper.mapToPaysDto(updatePaysobj);

    }

    @Override
    public void deletePays(Long paysId) {
       Pays pays = paysRepo.findById(paysId)
      .orElseThrow(() ->
       new ResourceNotFoundException("Pays avec cette id n'existe pas :"+ paysId)
       );   
      paysRepo.deleteById(paysId);
    }

}
