package com.pokemonreview.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemonreview.api.models.Commission;
import com.pokemonreview.api.repository.CommissionRepository;
import com.pokemonreview.api.service.CommissionService;

import lombok.AllArgsConstructor;
import java.util.Date;
@Service
@AllArgsConstructor
public class CommissionServiceImpl implements CommissionService{
     @Autowired
    private CommissionRepository commissionRepository;

    @Override
    public List<Commission> getAll(){
        return commissionRepository.findAll();
    }

    @Override
    public List<Commission> getById(Long id){
        return commissionRepository.findByIdCommision(id);
    }

    @Override
    public List<Commission> getByDate(Date date){
        return commissionRepository.findByDateComission(date);
    }

    @Override
    public Commission saveCommission(Commission commission){
        return commissionRepository.save(commission);
    }

}
