package com.example.gestion_sinistre.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    public Expert getExpert() {
        return expert;
    }

    public void setExpert(Expert expert) {
        this.expert = expert;
    }

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

    @JsonProperty("commentaireClient")
    private String commentaireClient;



    @JsonProperty("affectationDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String affectationDate;

    @JsonProperty("priority")
    private String priority;

    @JsonProperty("commentaireExpert")
    private String commentaireExpert;

    @JsonProperty("sinistreType")
    private String sinistreType;

    @JsonProperty("lieuSinistre")
    private String lieuSinistre;




    @ManyToOne
    @JoinColumn(name = "expert_id")
    @JsonBackReference(value = "expertRef")
    private Expert expert;

    @ManyToOne
    @JoinColumn(name = "gestionnaire_id")
    @JsonBackReference(value = "gestionnaireRef")
    private Gestionnaire gestionnaire;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateSinistre() {
        return dateSinistre;
    }

    public void setDateSinistre(LocalDate dateSinistre) {
        this.dateSinistre = dateSinistre;
    }

    public String getNumeroImmatriculation() {
        return numeroImmatriculation;
    }

    public void setNumeroImmatriculation(String numeroImmatriculation) {
        this.numeroImmatriculation = numeroImmatriculation;
    }

    public String getPhotoVehicule() {
        return photoVehicule;
    }

    public void setPhotoVehicule(String photoVehicule) {
        this.photoVehicule = photoVehicule;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getCommentaireClient() {
        return commentaireClient;
    }

    public void setCommentaireClient(String commentaireClient) {
        this.commentaireClient = commentaireClient;
    }

    public String getAffectationDate() {
        return affectationDate;
    }

    public void setAffectationDate(String affectationDate) {
        this.affectationDate = affectationDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getCommentaireExpert() {
        return commentaireExpert;
    }

    public void setCommentaireExpert(String commentaireExpert) {
        this.commentaireExpert = commentaireExpert;
    }

    public String getSinistreType() {
        return sinistreType;
    }

    public void setSinistreType(String sinistreType) {
        this.sinistreType = sinistreType;
    }

    public String getLieuSinistre() {
        return lieuSinistre;
    }

    public void setLieuSinistre(String lieuSinistre) {
        this.lieuSinistre = lieuSinistre;
    }

    public Gestionnaire getGestionnaire() {
        return gestionnaire;
    }

    public void setGestionnaire(Gestionnaire gestionnaire) {
        this.gestionnaire = gestionnaire;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
