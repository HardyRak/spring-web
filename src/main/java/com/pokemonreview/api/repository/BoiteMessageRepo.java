package com.pokemonreview.api.repository;


import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pokemonreview.api.models.BoiteMessage;

@Repository
public interface BoiteMessageRepo extends MongoRepository<BoiteMessage, ObjectId> {

    Optional<BoiteMessage> findByProprietaireIdAndInterlocuteurId(String proprietaireId, String interlocuteurId);

    List<BoiteMessage> findByProprietaireId(String proprietaireId);

    List<BoiteMessage> findByInterlocuteurId(String interlocuteurId);

  
}