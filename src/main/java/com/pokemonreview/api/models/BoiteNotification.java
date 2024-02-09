package com.pokemonreview.api.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.bson.types.ObjectId;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "boiteNotification")
@Getter
@Setter
public class BoiteNotification {
    @Id
    private ObjectId id;
    private String proprietaireId;
    private List<Notification> listeNotif;
}
