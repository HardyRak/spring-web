package com.pokemonreview.api.service;


import java.util.List;

import com.pokemonreview.api.dto.PaysDto;

public interface PaysService {
    PaysDto createPays(PaysDto paysDto);

    PaysDto getPaysById(Long paysId );

    List<PaysDto> getAllPays() ;

    PaysDto updatePays(Long paysId , PaysDto updatePays);

    void deletePays(Long paysId);
}
