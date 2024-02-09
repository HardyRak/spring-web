package com.pokemonreview.api.service;


import java.util.List;

import com.pokemonreview.api.dto.ParamCommissionDto;


public interface ParamCommissionService {

   ParamCommissionDto createParamCommission(ParamCommissionDto paramCommissionDto);

    ParamCommissionDto getParamCommissionById(Long paramCommissionId );

    List<ParamCommissionDto> getAllParamCommissions() ;

    ParamCommissionDto updateParamCommission(Long paramCommissionId , ParamCommissionDto updateParamCommission);

    void deleteParamCommission(Long paramCommissionId);
}
