package org.com.flashrent.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Soumission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String offre;
    private String situationProfessionnelle;
    private String situationFamiliale;
    private String message;
    private LocalDateTime date;

    @ManyToOne
    private Propriete propriete;

    @ManyToOne
    private Locataire locataire;

    // Constructeurs, getters, setters, et autres méthodes nécessaires
    // Assurez-vous d'avoir des constructeurs par défaut et avec tous les champs nécessaires.

    public Soumission() {
        // Constructeur par défaut nécessaire pour JPA
    }

    public Soumission(String offre, String situationProfessionnelle, String situationFamiliale, String message, LocalDateTime date, Propriete propriete, Locataire locataire) {
        this.offre = offre;
        this.situationProfessionnelle = situationProfessionnelle;
        this.situationFamiliale = situationFamiliale;
        this.message = message;
        this.date = date;
        this.propriete = propriete;
        this.locataire = locataire;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOffre() {
        return offre;
    }

    public void setOffre(String offre) {
        this.offre = offre;
    }

    public String getSituationProfessionnelle() {
        return situationProfessionnelle;
    }

    public void setSituationProfessionnelle(String situationProfessionnelle) {
        this.situationProfessionnelle = situationProfessionnelle;
    }

    public String getSituationFamiliale() {
        return situationFamiliale;
    }

    public void setSituationFamiliale(String situationFamiliale) {
        this.situationFamiliale = situationFamiliale;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Propriete getPropriete() {
        return propriete;
    }

    public void setPropriete(Propriete propriete) {
        this.propriete = propriete;
    }

    public Locataire getLocataire() {
        return locataire;
    }

    public void setLocataire(Locataire locataire) {
        this.locataire = locataire;
    }
}
