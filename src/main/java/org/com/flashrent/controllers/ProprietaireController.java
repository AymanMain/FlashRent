package org.com.flashrent.controllers;

import org.com.flashrent.entities.Proprietaire;
import org.com.flashrent.entities.Propriete;
import org.com.flashrent.services.ProprietaireService;
import org.com.flashrent.services.ProprieteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/owner")
public class ProprietaireController {
    private final ProprietaireService proprietaireService;
    private final ProprieteService proprieteService;  // assurez-vous d'injecter le service Propriete

    public ProprietaireController(ProprietaireService proprietaireService,ProprieteService proprieteService) {
        this.proprietaireService = proprietaireService;
        this.proprieteService = proprieteService;
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



    @GetMapping("/add")
    public String showAddPropertyForm(Model model) {
        model.addAttribute("propriete", new Propriete());
        return "owner/addProperty";
    }

    @PostMapping("/add")
    public String addProperty(@ModelAttribute Propriete propriete) {
        proprieteService.addPropriete(propriete);
        return "redirect:/owner/dashboard";
    }
    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        List<Propriete> listProprietes = proprieteService.findAll();
        model.addAttribute("listProprietes", listProprietes);
        return "owner/dashboard";
    }
}
