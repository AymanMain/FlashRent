package org.com.flashrent.controllers;

import org.com.flashrent.entities.Owner;
import org.com.flashrent.entities.Property;
import org.com.flashrent.entities.Locataire;
import org.com.flashrent.entities.Submission;
import org.com.flashrent.repositories.OwnerRepo;
import org.com.flashrent.repositories.PropertyRepo;
import org.com.flashrent.repositories.LocataireRepo;
import org.com.flashrent.repositories.SubmissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private OwnerRepo ownerRepository;

    @Autowired
    private PropertyRepo propertyRepository;

    @Autowired
    private LocataireRepo locataireRepository;

    @Autowired
    private SubmissionRepo submissionRepository;

    // Owner endpoints
    @PostMapping("/owner/register")
    public ResponseEntity<String> registerOwner(@RequestBody Owner owner) {
        ownerRepository.save(owner);
        return ResponseEntity.ok("Owner registered successfully.");
    }

    @PostMapping("/owner/login")
    public ResponseEntity<String> loginOwner(@RequestBody Owner owner) {
        Owner existingOwner = ownerRepository.findByEmail(owner.getEmail());
        if (existingOwner != null && existingOwner.getMotDePasse().equals(owner.getMotDePasse())) {
            return ResponseEntity.ok("Owner logged in successfully.");
        } else {
            return ResponseEntity.badRequest().body("Invalid username or password.");
        }
    }

    @GetMapping("/properties/owned")
    public ResponseEntity<List<Property>> getPropertiesOwnedByOwner(@RequestParam("ownerId") Long ownerId) {
        List<Property> properties = propertyRepository.findByOwnerId(ownerId);
        return ResponseEntity.ok(properties);
    }

    // Property endpoints
    @PostMapping("/property/add")
    public ResponseEntity<String> addProperty(@RequestBody Property property) {
        propertyRepository.save(property);
        return ResponseEntity.ok("Property added successfully.");
    }

    @PatchMapping("/property/{id}")
    public ResponseEntity<String> patchProperty(@PathVariable Long id, @RequestBody Property property) {
        Property existingProperty = propertyRepository.findById(id).orElse(null);
        if (existingProperty != null) {
            // Update existing property with new values
            existingProperty.setTitre(property.getTitre());
            existingProperty.setAdresse(property.getAdresse());
            propertyRepository.save(existingProperty);
            return ResponseEntity.ok("Property updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/property/{id}")
    public ResponseEntity<String> deleteProperty(@PathVariable Long id) {
        propertyRepository.deleteById(id);
        return ResponseEntity.ok("Property deleted successfully.");
    }

    // Locataire endpoints
    @PostMapping("/locataire/register")
    public ResponseEntity<String> registerLocataire(@RequestBody Locataire locataire) {
        locataireRepository.save(locataire);
        return ResponseEntity.ok("Locataire registered successfully.");
    }

    @PostMapping("/locataire/login")
    public ResponseEntity<String> loginLocataire(@RequestBody Locataire locataire) {
        Optional<Locataire> existingLocataireOptional = locataireRepository.findByEmail(locataire.getEmail());
        if (existingLocataireOptional.isPresent()) {
            Locataire existingLocataire = existingLocataireOptional.get();
            if (existingLocataire.getMotDePasse().equals(locataire.getMotDePasse())) {
                return ResponseEntity.ok("Locataire logged in successfully.");
            } else {
                return ResponseEntity.badRequest().body("Invalid password.");
            }
        } else {
            return ResponseEntity.badRequest().body("Locataire not found.");
        }
    }

    @GetMapping("/properties/all")
    public ResponseEntity<List<Property>> getAllProperties() {
        List<Property> properties = propertyRepository.findAll();
        return ResponseEntity.ok(properties);
    }

    @PostMapping("/submission/rent")
    public ResponseEntity<String> submitRentSubmission(@RequestBody Submission submission) {
        submissionRepository.save(submission);
        return ResponseEntity.ok("Rent submission successful.");
    }

    @GetMapping("/submission/bylocataire")
    public ResponseEntity<List<Submission>> getSubmissionByLocataire(@RequestParam("locataireId") Long locataireId) {
        List<Submission> submissions = submissionRepository.findByLocataireId(locataireId);
        return ResponseEntity.ok(submissions);
    }

    @DeleteMapping("/submission/{id}")
    public ResponseEntity<String> deleteSubmission(@PathVariable Long id) {
        submissionRepository.deleteById(id);
        return ResponseEntity.ok("Submission deleted successfully.");
    }
}
