package org.com.flashrent.controllers;

import org.com.flashrent.entities.Image;
import org.com.flashrent.entities.Propriete;
import org.com.flashrent.services.ProprieteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/propriete")
public class ProprieteController {

    private final ProprieteService proprieteService;

    @Autowired
    public ProprieteController(ProprieteService proprieteService) {
        this.proprieteService = proprieteService;
    }

    @GetMapping("/all")
    public String getAllProprietes(Model model) {
        model.addAttribute("listProprietes", proprieteService.getProprietes());
        return "dashboard"; // Retour à la vue de tableau de bord à la place de 'properties'
    }

    @GetMapping("/edit/{id}")
    public String showEditPropertyForm(@PathVariable Long id, Model model) {
        Propriete propriete = proprieteService.getProprieteById(id);
        model.addAttribute("propriete", propriete); // Ajouter la propriété à modifier au modèle
        return "editProperty"; // retourner la vue 'editProperty'
    }

    @PostMapping("/edit")
    public String editPropriete(@ModelAttribute("propriete") Propriete propriete, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "editProperty";
        }

        proprieteService.updatePropriete(propriete);
        return "redirect:/propriete/all";
    }

    @PostMapping("/delete/{id}")
    public String deletePropriete(@PathVariable("id") Long id) {
        proprieteService.deletePropriete(id);
        return "redirect:/owner/dashboard";
    }

    @GetMapping("/submissions/{id}")
    public String getSubmissionsOfPropriete(@PathVariable Long id, Model model) {
        Propriete propriete = proprieteService.getProprieteById(id);
        model.addAttribute("submissions", propriete.getSoumissions()); // Utilisez la méthode getSoumissions() ici
        return "submissions";
    }

    @GetMapping("/{id}")
    public String getProprieteById(@PathVariable Long id, Model model) {
        model.addAttribute("property", proprieteService.getProprieteById(id));
        return "propertyDetail"; // Assurez-vous que vous avez une vue appelée 'propertyDetail' pour afficher les détails d'une propriété
    }

    @GetMapping("/add")
    public String showAddPropertyForm(Model model) {
        model.addAttribute("propriete", new Propriete()); // créer un nouvel objet Propriete
        return "addProperty"; // retourner la vue addProperty
    }

    @PostMapping("/add")
    public String addPropriete(@ModelAttribute Propriete propriete, @RequestParam("photos") MultipartFile[] photos) throws IOException {
        List<Image> images = new ArrayList<>();

        for (MultipartFile photo : photos) {
            byte[] bytes = photo.getBytes();
            Image image = new Image(bytes);
            image.setPropriete(propriete);  // Ajoutez cette ligne pour lier l'image à la propriété
            images.add(image);
        }

        propriete.setImages(images);
        proprieteService.addPropriete(propriete);

        return "redirect:/propriete/all";
    }

}