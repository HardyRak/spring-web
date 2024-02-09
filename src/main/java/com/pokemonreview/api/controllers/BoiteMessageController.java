package com.pokemonreview.api.controllers;

import java.util.List;



import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pokemonreview.api.dto.MessageDto;
import com.pokemonreview.api.models.BoiteMessage;
import com.pokemonreview.api.service.BoiteMessageService;
import com.pokemonreview.api.service.BoiteNotificationService;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin(origins = "*")
public class BoiteMessageController {
    private final BoiteMessageService boiteMessage;

    @Autowired
    public BoiteMessageController(BoiteMessageService boiteMessage) {
        this.boiteMessage = boiteMessage;
    }
    @PostMapping("/envoyer")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> envoyerMessage(@RequestBody MessageDto messageDTO) {
        try {
            boiteMessage.envoyerMessage(messageDTO);
            return ResponseEntity.ok("Message envoyé avec succès");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erreur lors de l'envoi du message : " + e.getMessage());
        }
    }

    @GetMapping("/proprietaire/{proprietaireId}")
    @CrossOrigin(origins = "*")
    public List<BoiteMessage> getBoiteMessagesByProprietaireId(@PathVariable String proprietaireId) {
        return boiteMessage.getBoiteMessagesByProprietaireId(proprietaireId);
    }

    // Endpoint pour récupérer toutes les boiteMessages en fonction de l'interlocuteurId
    @GetMapping("/interlocuteur/{interlocuteurId}")
    @CrossOrigin(origins = "*")
    public List<BoiteMessage> getBoiteMessagesByInterlocuteurId(@PathVariable String interlocuteurId) {
        return boiteMessage.getBoiteMessagesByInterlocuteurId(interlocuteurId);
    }

    @GetMapping("/{proprietaireId}/{interlocuteurId}")
    @CrossOrigin(origins = "*")
    public BoiteMessage getBoiteMessagesProprietaireIdAndByInterlocuteurId(@PathVariable String proprietaireId,@PathVariable String interlocuteurId) {
        return boiteMessage.getOrCreateBoiteMessage(proprietaireId,interlocuteurId);
    }
}
