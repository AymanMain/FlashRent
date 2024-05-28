package org.com.flashrent.controllers;

import org.com.flashrent.entities.Proprietaire;
import org.com.flashrent.services.ProprietaireService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/owner")
public class ProprietaireController {
    private final ProprietaireService proprietaireService;

    public ProprietaireController(ProprietaireService proprietaireService) {
        this.proprietaireService = proprietaireService;
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("proprietaire", new Proprietaire());
        return "owner/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("proprietaire") Proprietaire proprietaire) {
        Proprietaire existingProprietaire = proprietaireService.findByEmail(proprietaire.getEmail());
        if (existingProprietaire != null && existingProprietaire.getMotDePasse().equals(proprietaire.getMotDePasse())) {
            return "redirect:/owner/dashboard";
        } else {
            return "redirect:/owner/login?error";
        }
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("proprietaire", new Proprietaire());
        return "owner/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("proprietaire") Proprietaire proprietaire) {
        proprietaireService.save(proprietaire);
        return "redirect:/owner/login";
    }

    @GetMapping("/dashboard")
    public String showDashboard() {
        return "owner/dashboard";
    }
}
