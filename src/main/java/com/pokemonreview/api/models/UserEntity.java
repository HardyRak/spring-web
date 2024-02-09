package com.pokemonreview.api.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Document(collection = "user")
@Data
@NoArgsConstructor

public class UserEntity {
    @Id
    private String id;
    private String username;
    private String prenoms;
    private String password;
    private String dateNaissance;
    private String genre;
    private String nationalite;
    private String mail;
    private int statut;
     private List<Role> roles = new ArrayList<>();
     
}
