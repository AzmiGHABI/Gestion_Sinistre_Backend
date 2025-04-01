package com.example.gestion_sinistre.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Expert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("nom")
    private String nom;

    @JsonProperty("prenom")
    private String prenom;

    @JsonProperty("email")
    private String email;

    @JsonProperty("motDePasse")
    private String motDePasse;

    @JsonProperty("cin")
    private String cin;

    @JsonProperty("numTel")
    private String numTel;

    @JsonProperty("adresse")
    private String adresse;
}
