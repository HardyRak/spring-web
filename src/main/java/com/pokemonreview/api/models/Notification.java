package com.pokemonreview.api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "notification")
public class Notification {
    @Id
    private String idNotif;
    private String dateNotification;
    private String contenu;
}
