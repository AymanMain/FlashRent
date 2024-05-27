package org.com.flashrent.entities;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;
import java.util.List;

@Setter
@Getter
@Entity
public class Proprietaire {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;

    @OneToMany(mappedBy = "proprietaire")
    private List<Propriete> proprietes;

    // Constructeur par défaut de JPA 
    public Proprietaire() {}

    // Constructeur
    public Proprietaire(String nom, String prenom, String email, String motDePasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
    }
}