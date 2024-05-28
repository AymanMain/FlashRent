package org.com.flashrent.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.util.codec.binary.Base64;

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

    @OneToMany(mappedBy = "propriete", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> images;

    @ManyToOne
    private Proprietaire proprietaire;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "propriete")
    private List<Soumission> soumissions;

    @ManyToOne
    private Locataire locataire;

    // Constructeur par défaut de JPA
    public Propriete() {}

    // Constructeur
    public Propriete(String nom, String description, String adresse, int prix, int nombreDeChambres, int nombreDeBains, int superficie, boolean fumeur, boolean animauxDomestiques, Proprietaire proprietaire) {
        this.nom = nom;
        this.description = description;
        this.adresse = adresse;
        this.prix = prix;
        this.nombreDeChambres = nombreDeChambres;
        this.nombreDeBains = nombreDeBains;
        this.superficie = superficie;
        this.fumeur = fumeur;
        this.animauxDomestiques = animauxDomestiques;
        this.proprietaire = proprietaire;
    }
    public String getImageBase64() {
        if (images != null && !images.isEmpty()) {
            return images.get(0).getImageBase64();
        }
        return null;
    }
}
