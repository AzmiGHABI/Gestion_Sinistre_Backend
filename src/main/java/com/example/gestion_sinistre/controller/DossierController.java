package com.example.gestion_sinistre.controller;

import com.example.gestion_sinistre.entity.Dossier;
import com.example.gestion_sinistre.service.DossierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.security.RolesAllowed;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT},
        maxAge = 3600
)

@RequestMapping("/api/dossiers")



public class DossierController {
    private final String UPLOAD_DIR = "C:/Users/takwa/Downloads" ;

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

    @PostMapping()
    @CrossOrigin(origins = "*", allowedHeaders = "*")

    public Dossier createDossier(@RequestBody Dossier dossier) {
        return dossierService.createDossier(dossier);
    }
    //@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> ajouterDossier(
            @RequestPart("nom") String nom,
            @RequestPart("prenom") String prenom,
            @RequestPart("email") String email,
            @RequestPart("dateSinistre") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateSinistre,
            @RequestPart("numeroImmatriculation") String numeroImmatriculation,
            @RequestPart("photoVehicule") MultipartFile photoVehicule,
            @RequestPart("lieuSinistre") String lieuSinistre,
            @RequestPart("commentaireClient") String commentaireClient,
            @RequestPart("statut") String statut,
            @RequestPart("cin") String cin
    ) {
        try {
            // 1. Créer le dossier s’il n’existe pas
            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            // 2. Construire le nom final du fichier (éviter les conflits)
            String fileName = UUID.randomUUID().toString() + "_" + photoVehicule.getOriginalFilename();
            Path filePath = Paths.get(UPLOAD_DIR + fileName);

            // 3. Sauvegarder le fichier
            Files.copy(photoVehicule.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // 4. Créer et sauvegarder l’objet Dossier
            Dossier dossier = new Dossier();
            dossier.setNom(nom);
            dossier.setPrenom(prenom);
            dossier.setEmail(email);
            dossier.setDateSinistre(dateSinistre);
            dossier.setNumeroImmatriculation(numeroImmatriculation);
            dossier.setLieuSinistre(lieuSinistre);
            dossier.setCommentaireClient(commentaireClient);
            dossier.setStatut(statut);
            dossier.setPhotoVehicule(fileName); // ⬅️ On sauvegarde juste le nom du fichier

            dossierService.createDossier(dossier);

            return ResponseEntity.ok("Dossier enregistré avec succès !");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la sauvegarde du fichier.");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteDossier(@PathVariable Long id) {
        dossierService.deleteDossier(id);
    }


    @GetMapping("/statut/{statut}")
    public List<Dossier> getDossiersByStatut(@PathVariable String statut) {
        return dossierService.getDossiersByStatut(statut);
    }
    @GetMapping("/debug-roles")
    public ResponseEntity<?> debugRoles(Authentication authentication) {
        return ResponseEntity.ok(authentication.getAuthorities());
    }
}
