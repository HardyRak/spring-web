package com.pokemonreview.api.models;

import lombok.Getter;
import lombok.Setter;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Setter
@Getter
@Document(collection = "roles")

public class Role {
    @Id
    private String id;
    private String name;
}
