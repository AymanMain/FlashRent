package org.com.flashrent.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Propriete {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;
    private String description;
    private String adresse;
    private int prix;
    private int nombreDeChambres;
    private int nombreDeBains;
    private int superficie;
    private boolean fumeur;
    private boolean animauxDomestiques;

    @ManyToOne
    private Proprietaire proprietaire;

    @OneToMany(mappedBy = "propriete")
    private List<Soumission> soumissions;

    // Getters and Setters
}
