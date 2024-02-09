package com.pokemonreview.api.models;

public class Images {
    private String nomImage;
    private String base64;

    public Images() {
    }

    public Images(String nomImage, String base64) {
        this.nomImage = nomImage;
        this.base64 = base64;
    }

    public String getNomImage() {
        return nomImage;
    }

    public void setNomImage(String nomImage) {
        this.nomImage = nomImage;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }
}