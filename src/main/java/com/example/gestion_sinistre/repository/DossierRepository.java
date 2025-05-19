package com.example.gestion_sinistre.repository;

import com.example.gestion_sinistre.entity.Dossier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DossierRepository extends CrudRepository<Dossier, Long> {

    // Dossiers par statut
    List<Dossier> findByStatut(String statut);


    List<Dossier> findByUsername(String username);

    // ✅ Total de dossiers traités
    long countByStatut(String statut);

    // ✅ Dossiers par gestionnaire
    @Query("SELECT d.gestionnaire.nom, COUNT(d) FROM Dossier d GROUP BY d.gestionnaire.nom")
    List<Object[]> countByGestionnaire();

    // ✅ Dossiers par expert
    @Query("SELECT d.expert.nom, COUNT(d) FROM Dossier d GROUP BY d.expert.nom")
    List<Object[]> countByExpert();
}
