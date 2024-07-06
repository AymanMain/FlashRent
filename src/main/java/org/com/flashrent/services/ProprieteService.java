package org.com.flashrent.services;

import org.com.flashrent.entities.Image;
import org.com.flashrent.entities.Propriete;
import org.com.flashrent.repositories.ProprieteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProprieteService {

    private final ProprieteRepository proprieteRepository;

    @Autowired
    public ProprieteService(ProprieteRepository proprieteRepository) {
        this.proprieteRepository = proprieteRepository;
    }

    public List<Propriete> getProprietes() {
        return proprieteRepository.findAll();
    }

    public Propriete getProprieteById(Long id) {
        return proprieteRepository.findByIdAndFetchSoumissionsEagerly(id)
                .orElseThrow(() -> new RuntimeException("No Propriete found with ID " + id));
    }


    public Propriete addPropriete(Propriete propriete) {
        return proprieteRepository.save(propriete);
    }

    public Propriete updatePropriete(Long id, Propriete updatedPropriete) {
        Propriete originalPropriete = getProprieteById(id);
        originalPropriete.setNom(updatedPropriete.getNom());
        originalPropriete.setDescription(updatedPropriete.getDescription());
        originalPropriete.setAdresse(updatedPropriete.getAdresse());
        originalPropriete.setPrix(updatedPropriete.getPrix());
        originalPropriete.setNombreDeChambres(updatedPropriete.getNombreDeChambres());
        originalPropriete.setNombreDeBains(updatedPropriete.getNombreDeBains());
        originalPropriete.setSuperficie(updatedPropriete.getSuperficie());
        originalPropriete.setFumeur(updatedPropriete.isFumeur());
        originalPropriete.setAnimauxDomestiques(updatedPropriete.isAnimauxDomestiques());
        // Set other properties as needed

        return proprieteRepository.save(originalPropriete);
    }

    public void deletePropriete(Long id) {
        proprieteRepository.deleteById(id);
    }

    public List<Propriete> getProprietesByProprietaire(Long proprietaireId) {
        return proprieteRepository.findByProprietaireId(proprietaireId);
    }

    public List<Propriete> getAvailableProprietes() {
        return proprieteRepository.findByLocataireIsNull();
    }

    @Autowired
    private ImageService imageService; // Injectez le ImageService qui a été ajouté.

    public Propriete addPropriete(Propriete propriete, MultipartFile[] photos) throws IOException {
        Propriete savedPropriete = proprieteRepository.save(propriete);

        for (MultipartFile photo : photos) {
            Image image = imageService.addImage(photo);
            image.setPropriete(savedPropriete);
            imageService.save(image); // Sauvegarde la mise à jour de l'image liée à la propriété.
        }

        return savedPropriete;
    }

    public List<Propriete> findAll() {
        return proprieteRepository.findAll();
    }

    public Propriete getPropriete(Long id) {
        return proprieteRepository.findById(id).orElse(null);
    }






}