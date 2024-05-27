package org.com.flashrent.services;

import org.com.flashrent.entities.Locataire;
import org.com.flashrent.repositories.LocataireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocataireService {

    private final LocataireRepository locataireRepository;

    @Autowired
    public LocataireService(LocataireRepository locataireRepository) {
        this.locataireRepository = locataireRepository;
    }

    public List<Locataire> findAll() {
        return locataireRepository.findAll();
    }

    public Optional<Locataire> findById(Long id) {
        return locataireRepository.findById(id);
    }

    public Locataire save(Locataire locataire) {
        // Avant de sauvegarder un nouveau locataire, vérifiez s'il existe déjà un locataire avec le même nom d'utilisateur
        // Notez que le mot de passe doit être stocké sous forme cryptée, ce qui n'est pas fait pour l'instant
        return locataireRepository.save(locataire);
    }

    public void delete(Locataire locataire) {
        locataireRepository.delete(locataire);
    }

    public Locataire findByEmail(String email) {
        return locataireRepository.findByEmail(email);
    }
    // Ajoutez d'autres méthodes nécessaires...
}