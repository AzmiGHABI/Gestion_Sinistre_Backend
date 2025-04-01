package com.example.gestion_sinistre.controller;

import com.example.gestion_sinistre.entity.Dossier;
import com.example.gestion_sinistre.service.DossierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dossiers")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class DossierController {

    @Autowired
    private DossierService dossierService;

    @GetMapping()
    public List<Dossier> getAllDossiers() {
        return dossierService.getAllDossiers();
    }

    @GetMapping("/{id}")
    public Optional<Dossier> getDossierById(@PathVariable Long id) {
        return dossierService.getDossierById(id);
    }

    @PostMapping
    public Dossier createDossier(@Validated @RequestBody Dossier dossier) {
        return dossierService.createDossier(dossier);
    }

    @DeleteMapping("/{id}")
    public void deleteDossier(@PathVariable Long id) {
        dossierService.deleteDossier(id);
    }


    @GetMapping("/statut/{statut}")
    public List<Dossier> getDossiersByStatut(@PathVariable String statut) {
        return dossierService.getDossiersByStatut(statut);
    }
}
