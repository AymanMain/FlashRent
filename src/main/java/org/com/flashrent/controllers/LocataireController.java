package org.com.flashrent.controllers;

import org.com.flashrent.entities.Locataire;
import org.com.flashrent.services.LocataireService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/locataire")
public class LocataireController {
    private final LocataireService locataireService;

    public LocataireController(LocataireService locataireService) {
        this.locataireService = locataireService;
    }

    @GetMapping("/login")
    public String showLocataireLoginForm() {
        return "locataire/login";
    }

    @PostMapping("/login")
    public String loginLocataire(@ModelAttribute("locataire") Locataire locataire) {
        Locataire existingLocataire = locataireService.findByEmail(locataire.getEmail());
        if (existingLocataire != null && existingLocataire.getMotDePasse().equals(locataire.getMotDePasse())) {
            // Login successful, redirect to the locataire dashboard or another appropriate page
            return "redirect:/locataire/dashboard";
        } else {
            // Login failed, redirect back to the login page
            return "redirect:/locataire/login";
        }
    }

    @GetMapping("/register")
    public String showLocataireRegistrationForm(Model model) {
        model.addAttribute("locataire", new Locataire());
        return "locataire/register";
    }

    @PostMapping("/register")
    public String registerLocataire(@ModelAttribute("locataire") Locataire locataire) {
        locataireService.save(locataire);
        return "redirect:/locataire/login";
    }

    @GetMapping
    public List<Locataire> getAllLocataires() {
        return locataireService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Locataire> getLocataireById(@PathVariable Long id) {
        return locataireService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Locataire> updateLocataire(@PathVariable Long id, @RequestBody Locataire locataire) {
        return locataireService.findById(id)
                .map(l -> {
                    // Do your updates here
                    return ResponseEntity.ok(locataireService.save(l));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLocataire(@PathVariable Long id) {
        return locataireService.findById(id)
                .map(l -> {
                    locataireService.delete(l);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}