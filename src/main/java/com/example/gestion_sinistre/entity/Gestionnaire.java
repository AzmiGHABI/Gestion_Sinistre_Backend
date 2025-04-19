package com.example.gestion_sinistre.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Gestionnaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @JsonProperty("nom")
    private String nom;

    @JsonProperty("prenom")
    private String prenom;

    @JsonProperty("email")
    private String email;

    @JsonProperty("cin")
    private String cin;

    @JsonProperty("numTel")
    private String numTel;

    @JsonProperty("adresse")
    private String adresse;

    @JsonProperty("region")
    private String region;



    @OneToMany(mappedBy = "gestionnaire", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "gestionnaireRef")
    private List<Dossier> dossiers = new ArrayList<>();

}
