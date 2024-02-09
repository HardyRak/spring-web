package com.pokemonreview.api.dto;

import lombok.Data;

@Data
public class RegisterDto {
    private String username;
    private String prenoms;
    private String password;
    private String dateNaissance;
    private String genre;
    private String nationalite;
    private String mail;}
