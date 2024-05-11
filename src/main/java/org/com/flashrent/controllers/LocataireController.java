//package org.com.flashrent.controllers;
//
//import org.com.flashrent.entities.Locataire;
//import org.com.flashrent.services.LocataireService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model; // Import the correct Model class
//import org.springframework.web.bind.annotation.*;
//
//@Controller // Use @Controller for handling web requests
//@RequestMapping("/locataires")
//public class LocataireController {
//    private final LocataireService locataireService;
//
//    public LocataireController(LocataireService locataireService) {
//        this.locataireService = locataireService;
//    }
//
//    @GetMapping("/login")
//    public String showLoginForm() {
//        return "locataire/locataire-login";
//    }
//
//    @PostMapping("/login")
//    public String processLogin(@RequestParam String username, @RequestParam String password) {
//        // Logic for authenticating the user
//        if (locataireService.authenticateLocataire(username, password)) {
//            return "redirect:/locataires/dashboard";
//        } else {
//            return "redirect:/locataires/login?error";
//        }
//    }
//
//    @GetMapping("/register")
//    public String showRegistrationForm(Model model) {
//        model.addAttribute("locataire", new Locataire());
//        return "locataire/locataire-register";
//    }
//
//    @PostMapping("/register")
//    public String processRegistration(@ModelAttribute Locataire locataire) {
//        // Logic for registering the user
//        locataireService.registerLocataire(locataire);
//        return "redirect:/locataires/login";
//    }
//
//    @GetMapping("/dashboard")
//    public String showDashboard(Model model) {
//        // Logic for displaying user dashboard
//        // Assuming you have a method in LocataireService to get the currently logged-in user
//        Locataire locataire = locataireService.getCurrentLocataire();
//        model.addAttribute("locataire", locataire);
//        return "locataire/locataire-dashboard";
//    }
//}
