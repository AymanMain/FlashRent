package org.com.flashrent.services;

import org.com.flashrent.entities.Locataire;
import org.com.flashrent.repositories.LocataireRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocataireService {
    @Autowired
    private LocataireRepo locataireRepository;

    public List<Locataire> getAllLocataires() {
        return locataireRepository.findAll();
    }

    public Optional<Locataire> getLocataireById(Long id) {
        return locataireRepository.findById(id);
    }

    public Locataire saveLocataire(Locataire locataire) {
        return locataireRepository.save(locataire);
    }

    public void deleteLocataireById(Long id) {
        locataireRepository.deleteById(id);
    }
}