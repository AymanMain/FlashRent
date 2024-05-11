//package org.com.flashrent.controllers;
//
//import org.com.flashrent.entities.Owner;
//import org.com.flashrent.entities.Property;
//import org.com.flashrent.services.OwnerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
//
//@Controller
//@RequestMapping("/owners")
//public class OwnerController {
//
//    private final OwnerService ownerService;
//
//    @Autowired
//    public OwnerController(OwnerService ownerService) {
//        this.ownerService = ownerService;
//    }
//
//    @GetMapping("/register")
//    public String showOwnerRegistrationForm(Model model) {
//        model.addAttribute("owner", new Owner());
//        return "owner/owner-register";
//    }
//
//    @PostMapping("/register")
//    public String processOwnerRegistration(@ModelAttribute Owner owner) {
//        ownerService.registerOwner(owner);
//        return "redirect:/owners/login";
//    }
//
//    @GetMapping("/login")
//    public String showOwnerLoginForm() {
//        return "owner/owner-login";
//    }
//
//    @PostMapping("/login")
//    public String processOwnerLogin(@RequestParam String email, @RequestParam String password) {
//        if (ownerService.authenticateOwner(email, password)) {
//            return "redirect:/owners/dashboard";
//        } else {
//            return "redirect:/owners/login?error";
//        }
//    }
//
//    @GetMapping("/dashboard")
//    public String showOwnerDashboard(Model model) {
//        List<Property> properties = ownerService.getOwnerProperties();
//        model.addAttribute("properties", properties);
//        return "owner/owner-dashboard";
//    }
//}
