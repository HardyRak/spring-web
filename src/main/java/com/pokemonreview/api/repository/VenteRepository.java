package com.pokemonreview.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.pokemonreview.api.models.Vente;

import java.util.List;
import java.sql.Date;
@RepositoryRestResource
public interface VenteRepository extends JpaRepository<Vente, Long> {
    List<Vente> findByIdutilisateur(String idUtilisateur);
    List<Vente> findByDateVente(Date datevente);
}
