package org.com.flashrent.controllers;

import org.com.flashrent.entities.Propriete;
import org.com.flashrent.services.ProprieteService;
import org.com.flashrent.services.SoumissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/propriete")
public class ProprieteController {

    private static final Logger logger = LoggerFactory.getLogger(ProprieteController.class);

    private final ProprieteService proprieteService;
    private final SoumissionService soumissionService;

    @Autowired
    public ProprieteController(ProprieteService proprieteService, SoumissionService soumissionService) {
        this.proprieteService = proprieteService;
        this.soumissionService = soumissionService;
    }

    @GetMapping("/dashboard")
    public String getAllProperties(Model model) {
        logger.info("Fetching all properties");
        model.addAttribute("listProperties", proprieteService.getProprietes());
        return "owner/dashboard"; // Ensure this view exists
    }

    @GetMapping("/edit/{id}")
    public String showEditPropertyForm(@PathVariable("id") Long id, Model model) {
        logger.info("Fetching property with ID {}", id);
        Propriete propriete = proprieteService.getPropriete(id);
        if (propriete == null) {
            logger.warn("Property with ID {} not found", id);
            return "redirect:/owner/dashboard";
        }
        model.addAttribute("propriete", propriete);
        return "owner/editProperty"; // Ensure this view exists
    }

    @PostMapping("/edit/{id}")
    public String editPropriete(@PathVariable("id") Long id, @ModelAttribute("propriete") Propriete propriete, BindingResult result, Model model) {
        logger.info("Updating property with ID {}", id);
        if (result.hasErrors()) {
            model.addAttribute("propriete", propriete);
            logger.warn("Validation errors encountered while updating property with ID {}", id);
            return "owner/editProperty";
        }
        proprieteService.updatePropriete(id, propriete);
        logger.info("Property with ID {} updated successfully", id);
        return "redirect:/owner/dashboard";
    }

    @PostMapping("/delete/{id}")
    public String deletePropriete(@PathVariable("id") Long id) {
        logger.info("Deleting property with ID {}", id);
        proprieteService.deletePropriete(id);
        logger.info("Property with ID {} deleted successfully", id);
        return "redirect:/owner/dashboard";
    }

    @GetMapping("/add")
    public String showAddPropertyForm(Model model) {
        logger.info("Rendering add property form");
        model.addAttribute("propriete", new Propriete());
        return "owner/addProperty"; // Ensure this view exists
    }

    @PostMapping("/add")
    public String addPropriete(@ModelAttribute Propriete propriete) throws IOException {
        logger.info("Adding new property");
        proprieteService.addPropriete(propriete);
        logger.info("New property added successfully");
        return "redirect:/owner/dashboard";
    }

    @GetMapping("/submission-list")
    public String showSubmissionList(Model model) {
        logger.info("Fetching all submissions");

        return "owner/submission-list"; // Ensure this view exists
    }
}
