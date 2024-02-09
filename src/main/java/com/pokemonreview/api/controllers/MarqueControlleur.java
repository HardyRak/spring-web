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

import com.pokemonreview.api.dto.MarqueDto;
import com.pokemonreview.api.service.MarqueService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/marque")
@CrossOrigin(origins = "*")
@Service 
public class MarqueControlleur {
    @Autowired
    private MarqueService marqueService;

     @PostMapping("/create")
    @CrossOrigin(origins = "*")
    public ResponseEntity<MarqueDto> createMarque(@RequestBody MarqueDto marqueDto){
        MarqueDto savedMarque = marqueService.createMarque(marqueDto);
        return new ResponseEntity<>(savedMarque , HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<MarqueDto> getMarqueById(@PathVariable("id")Long marqueId) {
        MarqueDto marqueDto = marqueService.getMarqueById(marqueId);
        return ResponseEntity.ok(marqueDto);

}
    @GetMapping("/all")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<MarqueDto>> getAllMarque(){
        List<MarqueDto> marques = marqueService.getAllMarque();
        return ResponseEntity.ok(marques);
    }
    @PutMapping("{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<MarqueDto> updateMarque (@PathVariable("id")  Long marqueId, 
                                                    @RequestBody MarqueDto updatedMarque){
    MarqueDto marqueDto = marqueService.updateMarque(marqueId, updatedMarque);
    return ResponseEntity.ok(marqueDto);

    }
    @DeleteMapping("{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> deleteMarque(@PathVariable("id")  Long marqueId){
        marqueService.deleteMarque(marqueId);
         return ResponseEntity.ok("Marque suprimer");
        

    }
}
