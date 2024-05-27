package org.com.flashrent.controllers;

import org.com.flashrent.entities.Soumission;
import org.com.flashrent.services.SoumissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/soumission")
public class SoumissionController {

    private final SoumissionService soumissionService;

    @Autowired
    public SoumissionController(SoumissionService soumissionService) {
        this.soumissionService = soumissionService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Soumission>> getAllSoumissions() {
        List<Soumission> soumissions = soumissionService.getSoumissions();
        return ResponseEntity.ok(soumissions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Soumission> getSoumissionById(@PathVariable Long id) {
        Soumission soumission = soumissionService.getSoumissionById(id);
        return ResponseEntity.ok(soumission);
    }

    @PostMapping("/add")
    public ResponseEntity<Soumission> addSoumission(@RequestBody Soumission soumission) {
        Soumission newSoumission = soumissionService.addSoumission(soumission);
        return ResponseEntity.ok(newSoumission);
    }

    @PutMapping("/update")
    public ResponseEntity<Soumission> updateSoumission(@RequestBody Soumission soumission) {
        Soumission updateSoumission = soumissionService.updateSoumission(soumission);
        return ResponseEntity.ok(updateSoumission);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSoumission(@PathVariable Long id) {
        soumissionService.deleteSoumission(id);
        return ResponseEntity.ok("La soumission avec l'ID " + id + " a été supprimée avec succès");
    }
}