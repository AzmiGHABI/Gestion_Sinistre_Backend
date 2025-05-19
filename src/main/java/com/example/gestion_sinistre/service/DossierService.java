package com.example.gestion_sinistre.service;

import com.example.gestion_sinistre.entity.Dossier;
import com.example.gestion_sinistre.repository.DossierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DossierService {

    @Autowired
    private DossierRepository dossierRepository;

    public List<Dossier> getAllDossiers() {
        return (List<Dossier>) dossierRepository.findAll();
    }

    public Optional<Dossier> getDossierById(Long id) {
        return dossierRepository.findById(id);
    }

    public Dossier createDossier(Dossier dossier) {
        return dossierRepository.save(dossier);
    }

    public void deleteDossier(Long id) {
        dossierRepository.deleteById(id);
    }


    public List<Dossier> getDossiersByStatut(String statut) {
        return dossierRepository.findByStatut(statut);
    }

    public List<Dossier> getDossiersByUsername(String username) {
        return dossierRepository.findByUsername(username);
    }


    public Dossier updateDossier(Dossier dossier) {
        if (dossier.getId() == null || !dossierRepository.existsById(dossier.getId())) {
            throw new IllegalArgumentException("Dossier ID invalide pour mise à jour");
        }
        return dossierRepository.save(dossier);
    }

}
