package com.example.gestion_sinistre.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Dossier {

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

    @JsonProperty("dateSinistre")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateSinistre;

    @JsonProperty("numeroImmatriculation")
    private String numeroImmatriculation;

    @JsonProperty("photoVehicule")
    private String photoVehicule;


    @JsonProperty("statut")
    private String statut;
}
