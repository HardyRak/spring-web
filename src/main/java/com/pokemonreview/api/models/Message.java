package com.pokemonreview.api.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "message")
@Getter
@Setter

public class Message {
    private String idEnvoyeur;
    private String contenu;
    private Date dateEnvoi;
}