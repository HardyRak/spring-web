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

import com.pokemonreview.api.dto.PaysDto;
import com.pokemonreview.api.service.PaysService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/pays")
@CrossOrigin(origins = "*")
@Service 
public class PaysControlleur {
    @Autowired
    private PaysService paysService;

    @PostMapping("/create")
    @CrossOrigin(origins = "*")
    public ResponseEntity<PaysDto> createPays(@RequestBody PaysDto paysDto){
        PaysDto savedPays = paysService.createPays(paysDto);
        return new ResponseEntity<>(savedPays , HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<PaysDto> getPaysById(@PathVariable("id")Long paysId) {
        PaysDto paysDto = paysService.getPaysById(paysId);
        return ResponseEntity.ok(paysDto);

}
    @GetMapping("/all")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<PaysDto>> getAllPays(){
        List<PaysDto> pays = paysService.getAllPays();
        return ResponseEntity.ok(pays);
    }
    @PutMapping("{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<PaysDto> updatePay (@PathVariable("id") Long paysId, 
                                                    @RequestBody PaysDto updatedPays){
    PaysDto paysDto = paysService.updatePays(paysId, updatedPays);
    return ResponseEntity.ok(paysDto);

    }
    @DeleteMapping("/delete/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> deletePays(@PathVariable("id")  Long paysId){
        paysService.deletePays(paysId);
         return ResponseEntity.ok("Pays suprimer");
        

    }
}
