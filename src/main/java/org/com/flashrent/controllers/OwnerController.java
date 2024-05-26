package org.com.flashrent.controllers;

import org.com.flashrent.entities.Owner;
import org.com.flashrent.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/owner")
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/login")
    public String showOwnerLoginForm() {
        return "owner/login";
    }

    @PostMapping("/login")
    public String loginOwner(@ModelAttribute("owner") Owner owner) {
        Owner existingOwner = ownerService.findByEmail(owner.getEmail());
        if (existingOwner != null && existingOwner.getMotDePasse().equals(owner.getMotDePasse())) {
            // Login successful, redirect to the owner dashboard or another appropriate page
            return "redirect:/owner/dashboard";
        } else {
            // Login failed, redirect back to the login page
            return "redirect:/owner/login";
        }
    }

    @GetMapping("/register")
    public String showOwnerRegistrationForm(Model model) {
        model.addAttribute("owner", new Owner());
        return "owner/register";
    }

    @PostMapping("/register")
    public String registerOwner(@ModelAttribute("owner") Owner owner) {
        ownerService.save(owner);
        return "redirect:/owner/login";
    }

    // Other methods for owner dashboard, etc.
}