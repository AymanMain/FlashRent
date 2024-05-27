package org.com.flashrent.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



import java.util.List;

@Getter
@Setter
@Entity
public class Locataire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;

    @OneToMany(mappedBy = "locataire")
    private List<Propriete> proprietes;

    // Constructeur par défaut de JPA
    public Locataire() {}

    // Constructeur
    public Locataire(String nom, String prenom, String email, String motDePasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
    }
}