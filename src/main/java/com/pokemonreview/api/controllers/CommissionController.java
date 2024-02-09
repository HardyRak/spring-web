package com.pokemonreview.api.controllers;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokemonreview.api.models.Commission;
import com.pokemonreview.api.service.CommissionService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@AllArgsConstructor
@RestController
@RequestMapping("/api/commission")
@CrossOrigin(origins = "*")
@Service
public class CommissionController {
    @Autowired
    private CommissionService commissionService;
    
    @GetMapping("/all")
    @CrossOrigin(origins = "*")
    public List<Commission> findAllCommition(){
        return commissionService.getAll();
    }

    @GetMapping("{id}")
    @CrossOrigin(origins = "*")
    public List<Commission> findById(@PathVariable Long id){
        return commissionService.getById(id);
    }

    @GetMapping("/{date}")
    @CrossOrigin(origins = "*")
    public List<Commission> findByDate(@PathVariable Date date){
        return commissionService.getByDate(date);
    }
 
    @PostMapping("/save")
    @CrossOrigin(origins = "*")
    public Commission saveCommission(@RequestBody Commission commission){
        return commissionService.saveCommission(commission);
    }

}
