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
        return dossierRepository.findAll();
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
}
