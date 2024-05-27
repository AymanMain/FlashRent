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
        List<Propriete> proprietes = proprieteService.getProprietes();
        return ResponseEntity.ok(proprietes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Propriete> getProprieteById(@PathVariable Long id) {
        Propriete propriete = proprieteService.getProprieteById(id);
        return ResponseEntity.ok(propriete);
    }

    @PostMapping("/add")
    public ResponseEntity<Propriete> addPropriete(@RequestBody Propriete propriete) {
        Propriete newPropriete = proprieteService.addPropriete(propriete);
        return ResponseEntity.ok(newPropriete);
    }

    @PutMapping("/update")
    public ResponseEntity<Propriete> updatePropriete(@RequestBody Propriete propriete) {
        Propriete updatePropriete = proprieteService.updatePropriete(propriete);
        return ResponseEntity.ok(updatePropriete);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePropriete(@PathVariable Long id) {
        proprieteService.deletePropriete(id);
        return ResponseEntity.ok("La propriété avec l'ID " + id + " a été supprimée avec succès");
    }
}