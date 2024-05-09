package org.com.flashrent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/locataires")
public class LocataireController {

    @GetMapping("/register")
    public String showLocataireRegistrationForm() {
        return "locataire/locataire-register";
    }

    @GetMapping("/login")
    public String showLocataireLoginForm() {
        return "locataire/locataire-login";
    }

    @GetMapping("/dashboard")
    public String showLocataireDashboard() {
        return "locataire/locataire-dashboard";
    }

    @GetMapping("/properties/search")
    public String showPropertySearchForm() {
        return "locataire/property-search";
    }

    @GetMapping("/submissions/form")
    public String showSubmissionForm() {
        return "locataire/submission-form";
    }

    @GetMapping("/submissions")
    public String showSubmissionList() {
        return "locataire/submission-list";
    }
}
