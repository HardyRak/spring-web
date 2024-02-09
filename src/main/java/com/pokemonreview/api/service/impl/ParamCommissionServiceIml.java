package com.pokemonreview.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;

import com.pokemonreview.api.dto.ParamCommissionDto;
import com.pokemonreview.api.exceptions.ResourceNotFoundException;
import com.pokemonreview.api.models.ParamCommission;
import com.pokemonreview.api.models.mapper.ParamCommissionMapper;
import com.pokemonreview.api.repository.ParamCommissionRepo;
import com.pokemonreview.api.service.ParamCommissionService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ParamCommissionServiceIml implements ParamCommissionService {
    
  private ParamCommissionRepo paramCommissionRepo;

    @Override
    public ParamCommissionDto createParamCommission(ParamCommissionDto paramCommissionDto) {
       ParamCommission paramCommission = ParamCommissionMapper.mapToParamCommission(paramCommissionDto);
       ParamCommission savedParamCommission= paramCommissionRepo.save(paramCommission);

       return ParamCommissionMapper.mapToParamCommissionDto(savedParamCommission);
    }

    @Override
    public ParamCommissionDto getParamCommissionById(Long paramCommissionId) {
   ParamCommission paramCommission = paramCommissionRepo.findById(paramCommissionId)
        .orElseThrow(() -> 
        new ResourceNotFoundException("ParamCommission avec cette id n'existe pas :"+ paramCommissionId));
    return ParamCommissionMapper.mapToParamCommissionDto(paramCommission);
    }

    @Override
    public List<ParamCommissionDto> getAllParamCommissions() {
        List<ParamCommission>ParamCommission=paramCommissionRepo.findAll();
        return ParamCommission.stream().map((paramCommission) -> ParamCommissionMapper.mapToParamCommissionDto(paramCommission)) 
               .collect(Collectors.toList());
    }

    @Override
    public ParamCommissionDto updateParamCommission(Long paramCommissionId, ParamCommissionDto updateParamCommission) {
      ParamCommission paramCommission = paramCommissionRepo.findById(paramCommissionId)
      .orElseThrow(() ->
       new ResourceNotFoundException("ParamCommission avec cette id n'existe pas :"+ paramCommissionId)
       );
        paramCommission.setMaxPrix(updateParamCommission.getMaxPrix());
        paramCommission.setMinPrix(updateParamCommission.getMinPrix());
        paramCommission.setPourcentage(updateParamCommission.getPourcentage());

        ParamCommission updateParamCommissionsobj=paramCommissionRepo.save(paramCommission);
        return ParamCommissionMapper.mapToParamCommissionDto(updateParamCommissionsobj);

    }

    @Override
    public void deleteParamCommission(Long paramCommissionId) {
       ParamCommission paramCommission = paramCommissionRepo.findById(paramCommissionId)
      .orElseThrow(() ->
       new ResourceNotFoundException("ParamCommission avec cette id n'existe pas :"+ paramCommissionId)
       );   
      paramCommissionRepo.deleteById(paramCommissionId);
    }
}
