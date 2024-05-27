//package org.com.flashrent.controllers;
//
//import org.com.flashrent.entities.Proprietaire;
//import org.com.flashrent.entities.Propriete;
//import org.com.flashrent.entities.Locataire;
//import org.com.flashrent.repositories.ProprietaireRepository;
//import org.com.flashrent.repositories.ProprieteRepository;
//import org.com.flashrent.repositories.LocataireRepository;
//import org.com.flashrent.repositories.SoumissionRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api")
//public class ApiController {
//
//    @Autowired
//    private ProprietaireRepository ownerRepository;
//
//    @Autowired
//    private ProprieteRepository propertyRepository;
//
//    @Autowired
//    private LocataireRepository locataireRepository;
//
//    @Autowired
//    private SoumissionRepository submissionRepository;
//
//    // Proprietaire endpoints
//    @PostMapping("/owner/register")
//    public ResponseEntity<String> registerOwner(@RequestBody Proprietaire proprietaire) {
//        ownerRepository.save(proprietaire);
//        return ResponseEntity.ok("Proprietaire registered successfully.");
//    }
//
//    @PostMapping("/owner/login")
//    public ResponseEntity<String> loginOwner(@RequestBody Proprietaire proprietaire) {
//        Proprietaire existingProprietaire = ownerRepository.findByEmail(proprietaire.getEmail());
//        if (existingProprietaire != null && existingProprietaire.getMotDePasse().equals(proprietaire.getMotDePasse())) {
//            return ResponseEntity.ok("Proprietaire logged in successfully.");
//        } else {
//            return ResponseEntity.badRequest().body("Invalid username or password.");
//        }
//    }
//
//    @GetMapping("/properties/owned")
//    public ResponseEntity<List<Propriete>> getPropertiesOwnedByOwner(@RequestParam("ownerId") Long ownerId) {
//        List<Propriete> properties = propertyRepository.findByOwnerId(ownerId);
//        return ResponseEntity.ok(properties);
//    }
//
//    // Propriete endpoints
//    @PostMapping("/property/add")
//    public ResponseEntity<String> addProperty(@RequestBody Propriete propriete) {
//        propertyRepository.save(propriete);
//        return ResponseEntity.ok("Propriete added successfully.");
//    }
//
//    @PatchMapping("/property/{id}")
//    public ResponseEntity<String> patchProperty(@PathVariable Long id, @RequestBody Propriete propriete) {
//        Propriete existingPropriete = propertyRepository.findById(id).orElse(null);
//        if (existingPropriete != null) {
//            // Update existing propriete with new values
//            existingPropriete.setTitre(propriete.getTitre());
//            existingPropriete.setAdresse(propriete.getAdresse());
//            propertyRepository.save(existingPropriete);
//            return ResponseEntity.ok("Propriete updated successfully.");
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/property/{id}")
//    public ResponseEntity<String> deleteProperty(@PathVariable Long id) {
//        propertyRepository.deleteById(id);
//        return ResponseEntity.ok("Propriete deleted successfully.");
//    }
//
//    // Locataire endpoints
//    @PostMapping("/locataire/register")
//    public ResponseEntity<String> registerLocataire(@RequestBody Locataire locataire) {
//        locataireRepository.save(locataire);
//        return ResponseEntity.ok("Locataire registered successfully.");
//    }
//
//    @PostMapping("/locataire/login")
//    public ResponseEntity<String> loginLocataire(@RequestBody Locataire locataire) {
//        Optional<Locataire> existingLocataireOptional = locataireRepository.findByEmail(locataire.getEmail());
//        if (existingLocataireOptional.isPresent()) {
//            Locataire existingLocataire = existingLocataireOptional.get();
//            if (existingLocataire.getMotDePasse().equals(locataire.getMotDePasse())) {
//                return ResponseEntity.ok("Locataire logged in successfully.");
//            } else {
//                return ResponseEntity.badRequest().body("Invalid password.");
//            }
//        } else {
//            return ResponseEntity.badRequest().body("Locataire not found.");
//        }
//    }
//
//    @GetMapping("/properties/all")
//    public ResponseEntity<List<Propriete>> getAllProperties() {
//        List<Propriete> properties = propertyRepository.findAll();
//        return ResponseEntity.ok(properties);
//    }
//
//    @PostMapping("/submission/rent")
//    public ResponseEntity<String> submitRentSubmission(@RequestBody Propriete propriete) {
//        submissionRepository.save(propriete);
//        return ResponseEntity.ok("Rent propriete successful.");
//    }
//
//    @GetMapping("/submission/bylocataire")
//    public ResponseEntity<List<Propriete>> getSubmissionByLocataire(@RequestParam("locataireId") Long locataireId) {
//        List<Propriete> proprietes = submissionRepository.findByLocataireId(locataireId);
//        return ResponseEntity.ok(proprietes);
//    }
//
//    @DeleteMapping("/submission/{id}")
//    public ResponseEntity<String> deleteSubmission(@PathVariable Long id) {
//        submissionRepository.deleteById(id);
//        return ResponseEntity.ok("Propriete deleted successfully.");
//    }
//}
