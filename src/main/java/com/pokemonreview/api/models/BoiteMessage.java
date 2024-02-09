package com.pokemonreview.api.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "boiteMessage")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoiteMessage {
    @Id
    private ObjectId id;
    private String proprietaireId;
    private String interlocuteurId;
    private List<Message> listeMessages;
}