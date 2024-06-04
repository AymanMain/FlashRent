package org.com.flashrent.controllers;

import org.com.flashrent.entities.Image;
import org.com.flashrent.entities.Propriete;
import org.com.flashrent.repositories.ProprieteRepository;
import org.com.flashrent.services.ProprietaireService;
import org.com.flashrent.services.ProprieteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/propriete")
public class ProprieteController {

    private final ProprieteService proprieteService;

    @Autowired
    private ProprieteRepository proprieteRepository;
    @Autowired
    public ProprieteController(ProprieteService proprieteService) {
        this.proprieteService = proprieteService;

    }

    @GetMapping("/all")
    public String getAllProprieties(Model model) {
        model.addAttribute("listProprieties", proprieteService.getProprietes());
        return "dashboard"; // Retour à la vue de tableau de bord à la place de 'properties'
    }

    @GetMapping("/edit/{id}")
    public String showEditPropertyForm(@PathVariable("id") Long id, Model model) {
        Propriete propriete = proprieteService.getPropriete(id);
        if (propriete == null) {
            return "redirect:/owner/dashboard";
        }
        model.addAttribute("propriete", propriete);
        return "owner/editProperty";
    }


    @PostMapping("/edit")
    public String editPropriete(@ModelAttribute("propriete") Propriete propriete, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "owner/editProperty";
        }
        proprieteService.updatePropriete(propriete);
        return "redirect:/dashboard";
    }

    @GetMapping("/propriete/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {

        Optional<Propriete> proprieteOptional = proprieteRepository.findById(id);

        if (proprieteOptional.isPresent()) {
            model.addAttribute("propriete", proprieteOptional.get());
            return "owner/editPropriete";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/delete/{id}")
    public String deletePropriete(@PathVariable("id") Long id) {
        proprieteService.deletePropriete(id);
        return "redirect:/dashboard";
    }

    @PostMapping("/edit/{id}")
    public String editPropriete(@PathVariable("id") Long id, @ModelAttribute("propriete") Propriete propriete,
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "owner/editProperty";
        }
        proprieteService.updatePropriete(id, propriete);
        return "redirect:/dashboard";
    }

    @GetMapping("/submissions/{id}")
    public String getSubmissionsOfPropriete(@PathVariable Long id, Model model) {
        Propriete propriete = proprieteService.getPropriete(id);
        model.addAttribute("submissions", propriete.getSoumissions());
        return "submissions";
    }

    @GetMapping("/{id}")
    public String getProprieteById(@PathVariable Long id, Model model) {
        model.addAttribute("property", proprieteService.getPropriete(id));
        return "propertyDetail";
    }

    @GetMapping("/add")
    public String showAddPropertyForm(Model model) {
        model.addAttribute("propriete", new Propriete());
        return "addProperty";
    }

    @PostMapping("/add")
    public String addPropriete(@ModelAttribute Propriete propriete, @RequestParam("photos") MultipartFile[] photos) throws IOException {
        List<Image> images = new ArrayList<>();
        for (MultipartFile photo : photos) {
            byte[] bytes = photo.getBytes();
            Image image = new Image(bytes);
            image.setPropriete(propriete);
            images.add(image);
        }
        propriete.setImages(images);
        proprieteService.addPropriete(propriete);
        return "redirect:/dashboard";
    }
}