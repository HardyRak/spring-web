package com.pokemonreview.api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;

@Getter
@Document(collection = "database_sequences")
public class DatabaseSequence {
    @Id
    private String id;
    private Long seq;
    // Getters et setters

}