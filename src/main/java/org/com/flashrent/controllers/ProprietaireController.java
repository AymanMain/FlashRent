package org.com.flashrent.controllers;

import org.com.flashrent.entities.Proprietaire;
import org.com.flashrent.services.ProprietaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proprietaires")
public class ProprietaireController {

    private final ProprietaireService proprietaireService;

    @Autowired
    public ProprietaireController(ProprietaireService proprietaireService) {
        this.proprietaireService = proprietaireService;
    }

    @GetMapping
    public List<Proprietaire> getAllProprietaires() {
        return proprietaireService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proprietaire> getProprietaireById(@PathVariable Long id) {
        return proprietaireService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Proprietaire addNewProprietaire(@RequestBody Proprietaire proprietaire) {
        return proprietaireService.save(proprietaire);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proprietaire> updateProprietaire(@PathVariable Long id, @RequestBody Proprietaire proprietaire) {
        return proprietaireService.findById(id)
                .map(existingProprietaire -> {
                    proprietaire.setId(existingProprietaire.getId());
                    return ResponseEntity.ok(proprietaireService.save(proprietaire));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProprietaire(@PathVariable Long id) {
        if (proprietaireService.findById(id).isPresent()) {
            proprietaireService.delete(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    // Vous pouvez ajouter plus de méthodes pour gérer des requêtes spécifiques.
}