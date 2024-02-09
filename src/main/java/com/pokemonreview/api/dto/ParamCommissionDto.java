package com.pokemonreview.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParamCommissionDto {
    private long id;
    private int minPrix;
    private int maxPrix;
    private int pourcentage;
}
