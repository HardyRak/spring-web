package com.pokemonreview.api.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemonreview.api.models.BoiteMessage;
import com.pokemonreview.api.models.Message;
import  com.pokemonreview.api.dto.MessageDto;
import com.pokemonreview.api.repository.BoiteMessageRepo;

@Service
public class BoiteMessageService {
    private final BoiteMessageRepo boiteMessageRepository;

    @Autowired
    public BoiteMessageService(BoiteMessageRepo boiteMessageRepository) {
        this.boiteMessageRepository = boiteMessageRepository;
    }
        public void envoyerMessage(MessageDto messageDTO) {
        BoiteMessage boiteMessage = getOrCreateBoiteMessage(messageDTO.getProprietaireId(), messageDTO.getInterlocuteurId());

        Message message = new Message();
        message.setIdEnvoyeur(messageDTO.getExpediteurId());
        message.setContenu(messageDTO.getContenu());
        message.setDateEnvoi(new Date());

        if (boiteMessage.getListeMessages()== null) {
            boiteMessage.setListeMessages(new ArrayList<>());
        }

        boiteMessage.getListeMessages().add(message);

        boiteMessageRepository.save(boiteMessage);
    }

    public BoiteMessage getOrCreateBoiteMessage(String proprietaireId, String interlocuteurId) {
        Optional<BoiteMessage> existingBoiteMessage = boiteMessageRepository.findByProprietaireIdAndInterlocuteurId(proprietaireId, interlocuteurId);

        return existingBoiteMessage.orElseGet(() -> {
            BoiteMessage newBoiteMessage = new BoiteMessage();
            newBoiteMessage.setProprietaireId(proprietaireId);
            newBoiteMessage.setInterlocuteurId(interlocuteurId);
            return newBoiteMessage;
        });
    }
    public List<BoiteMessage> getBoiteMessagesByProprietaireId(String proprietaireId) {
        return boiteMessageRepository.findByProprietaireId(proprietaireId);
    }

    public List<BoiteMessage> getBoiteMessagesByInterlocuteurId(String interlocuteurId) {
        return boiteMessageRepository.findByInterlocuteurId(interlocuteurId);
    }
}