package org.com.flashrent.controllers;

import org.com.flashrent.entities.Locataire;
import org.com.flashrent.entities.Propriete;
import org.com.flashrent.services.LocataireService;
import org.com.flashrent.services.ProprieteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/locataire")
public class LocataireController {
    private final LocataireService locataireService;
    private final ProprieteService proprieteService;

    public LocataireController(LocataireService locataireService, ProprieteService proprieteService) {
        this.locataireService = locataireService;
        this.proprieteService = proprieteService;
    }

    @GetMapping("/login")
    public String showLocataireLoginForm() {
        return "locataire/login";
    }

    @PostMapping("/login")
    public String loginLocataire(@ModelAttribute("locataire") Locataire locataire) {
        Locataire existingLocataire = locataireService.findByEmail(locataire.getEmail());
        if (existingLocataire != null && existingLocataire.getMotDePasse().equals(locataire.getMotDePasse())) {
            // Login successful, redirect to the locataire dashboard
            return "redirect:/locataire/dashboard";
        } else {
            // Login failed, redirect back to the login page with an error message
            return "redirect:/locataire/login?error";
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

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        List<Propriete> listProprietes = proprieteService.findAll();
        model.addAttribute("listProprietes", listProprietes);
        return "locataire/dashboard";
    }
    @GetMapping("/soumission")
    public String showSoumission() {
        return "locataire/soumission";
    }

    // Other methods for locataire dashboard, etc.
}