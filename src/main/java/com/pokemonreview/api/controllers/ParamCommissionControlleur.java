package com.pokemonreview.api.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokemonreview.api.dto.ParamCommissionDto;
import com.pokemonreview.api.service.ParamCommissionService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/paramCommission")
@CrossOrigin(origins = "*")
@Service 
public class ParamCommissionControlleur {

     @Autowired
    private ParamCommissionService paramCommissionService;

    @PostMapping("/create")
    @CrossOrigin(origins = "*")
    public ResponseEntity<ParamCommissionDto> createParamCommission(@RequestBody ParamCommissionDto paramCommissionDto){
        ParamCommissionDto savedParamCommission = paramCommissionService.createParamCommission(paramCommissionDto);
        return new ResponseEntity<>(savedParamCommission , HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<ParamCommissionDto> getParamCommissionById(@PathVariable("id")Long paramCommissionId) {
        ParamCommissionDto paramCommissionDto = paramCommissionService.getParamCommissionById(paramCommissionId);
        return ResponseEntity.ok(paramCommissionDto);

    }

    @GetMapping("/all")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<ParamCommissionDto>> getAllParamCommissions(){
        List<ParamCommissionDto> paramCommission = paramCommissionService.getAllParamCommissions();
        return ResponseEntity.ok(paramCommission);
    }
    @PutMapping("{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<ParamCommissionDto> updateParamCommission (@PathVariable("id")  Long paramCommissionId, 
                                                    @RequestBody ParamCommissionDto updatedparamCommission){
    ParamCommissionDto paramCommissionDto = paramCommissionService.updateParamCommission(paramCommissionId, updatedparamCommission);
    return ResponseEntity.ok(paramCommissionDto);

    }
    @DeleteMapping("{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> deleteMarque(@PathVariable("id")  Long paramCommissionId){
        paramCommissionService.deleteParamCommission(paramCommissionId);
         return ResponseEntity.ok("Marque suprimer");
        

    }
}
