package org.com.flashrent.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Soumission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String message;
    private String date;

    @ManyToOne
    private Propriete propriete;

    @ManyToOne
    private Locataire locataire;

    // Constructeur par défaut de JPA
    public Soumission() {}

    // Constructeur
    public Soumission(String message, String date, Propriete propriete, Locataire locataire) {
        this.message = message;
        this.date = date;
        this.propriete = propriete;
        this.locataire = locataire;
    }
}
