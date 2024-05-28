package org.com.flashrent.controllers;

import org.com.flashrent.entities.Propriete;
import org.com.flashrent.services.ProprieteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/propriete")
public class ProprieteController {

    private final ProprieteService proprieteService;

    @Autowired
    public ProprieteController(ProprieteService proprieteService) {
        this.proprieteService = proprieteService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Propriete>> getAllProprietes() {
        return ResponseEntity.ok(proprieteService.getProprietes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Propriete> getProprieteById(@PathVariable Long id) {
        return ResponseEntity.ok(proprieteService.getProprieteById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Propriete> addPropriete(@RequestBody Propriete propriete) {
        return ResponseEntity.ok(proprieteService.addPropriete(propriete));
    }

    @PutMapping("/update")
    public ResponseEntity<Propriete> updatePropriete(@RequestBody Propriete propriete) {
        return ResponseEntity.ok(proprieteService.updatePropriete(propriete));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePropriete(@PathVariable Long id) {
        proprieteService.deletePropriete(id);
        return ResponseEntity.ok("La propriété avec l'ID " + id + " a été supprimée avec succès");
    }

    @GetMapping("/proprietaire/{proprietaireId}")
    public ResponseEntity<List<Propriete>> getProprietesByProprietaire(@PathVariable Long proprietaireId) {
        return ResponseEntity.ok(proprieteService.getProprietesByProprietaire(proprietaireId));
    }

    @GetMapping("/available")
    public ResponseEntity<List<Propriete>> getAvailableProprietes() {
        return ResponseEntity.ok(proprieteService.getAvailableProprietes());
    }
}