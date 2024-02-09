package com.pokemonreview.api.models.mapper;

import com.pokemonreview.api.dto.ParamCommissionDto;
import com.pokemonreview.api.models.ParamCommission;

public class ParamCommissionMapper {
      public static ParamCommissionDto mapToParamCommissionDto(ParamCommission paramCommission){
        return new ParamCommissionDto(
            paramCommission.getId(),
            paramCommission.getMinPrix(),
            paramCommission.getMaxPrix(),
            paramCommission.getPourcentage()
        );
    }
     public static ParamCommission mapToParamCommission(ParamCommissionDto paramCommissionDto){
        return new ParamCommission(
             paramCommissionDto.getId(),
            paramCommissionDto.getMinPrix(),
            paramCommissionDto.getMaxPrix(),
            paramCommissionDto.getPourcentage()
       
        );
    }
}
