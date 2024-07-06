package org.com.flashrent.controllers;

import org.com.flashrent.entities.Soumission;
import org.com.flashrent.services.SoumissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/locataire")
public class SoumissionController {

    private final SoumissionService soumissionService;

    // Options pour les listes déroulantes
    private final List<String> situationProfessionnelles = Arrays.asList("Employé", "Étudiant", "Retraité");
    private final List<String> situationsFamiliales = Arrays.asList("Célibataire", "Marié", "Divorcé", "Non spécifié");

    @Autowired
    public SoumissionController(SoumissionService soumissionService) {
        this.soumissionService = soumissionService;
    }

    @GetMapping("/submission")
    public String showSubmissionForm(Model model) {
        model.addAttribute("soumission", new Soumission());
        model.addAttribute("situationProfessionnelles", situationProfessionnelles);
        model.addAttribute("situationsFamiliales", situationsFamiliales);
        return "locataire/soumission";
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute("soumission") Soumission soumission) {
        soumissionService.addSoumission(soumission);
        return "redirect:/locataire/dashboard";
    }
}
