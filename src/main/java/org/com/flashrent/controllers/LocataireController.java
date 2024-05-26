package org.com.flashrent.controllers;

import org.com.flashrent.entities.Locataire;
import org.com.flashrent.services.LocataireService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    // Other methods for locataire dashboard, etc.
}