package com.example.gestion_sinistre.repository;

import com.example.gestion_sinistre.entity.Dossier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DossierRepository extends JpaRepository<Dossier, Long> {

    List<Dossier> findByStatut(String statut);
}
