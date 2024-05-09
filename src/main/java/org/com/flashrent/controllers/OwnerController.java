package org.com.flashrent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    @GetMapping("/register")
    public String showOwnerRegistrationForm() {
        return "owner/owner-register";
    }

    @GetMapping("/login")
    public String showOwnerLoginForm() {
        return "owner/owner-login";
    }

    @GetMapping("/dashboard")
    public String showOwnerDashboard() {
        return "owner/owner-dashboard";
    }

    @GetMapping("/properties/add")
    public String showAddPropertyForm() {
        return "owner/property-add";
    }

    @GetMapping("/properties")
    public String showPropertyList() {
        return "owner/property-list";
    }

    @GetMapping("/properties/{id}")
    public String showPropertyDetails() {
        return "owner/property-details";
    }

    @GetMapping("/submissions")
    public String showSubmissionList() {
        return "owner/submission-list";
    }
}
