package org.com.flashrent.services;

import org.com.flashrent.entities.Proprietaire;
import org.com.flashrent.repositories.ProprietaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProprietaireService {

    private final ProprietaireRepository proprietaireRepository;

    @Autowired
    public ProprietaireService(ProprietaireRepository proprietaireRepository) {
        this.proprietaireRepository = proprietaireRepository;
    }

    public List<Proprietaire> findAll() {
        return proprietaireRepository.findAll();
    }

    public Optional<Proprietaire> findById(Long id) {
        return proprietaireRepository.findById(id);
    }

    public Proprietaire save(Proprietaire proprietaire) {
        return proprietaireRepository.save(proprietaire);
    }

    public void delete(Proprietaire proprietaire) {
        proprietaireRepository.delete(proprietaire);
    }

    public Proprietaire findByEmail(String email) {
        return proprietaireRepository.findByEmail(email);
    }

    public void delete(Long id) {
        proprietaireRepository.deleteById(id);
    }
    // Ajoutez d'autres méthodes nécessaires...
}