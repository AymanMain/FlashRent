package org.com.flashrent.services;

import org.com.flashrent.entities.Soumission;
import org.com.flashrent.repositories.SoumissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoumissionService {

    private final SoumissionRepository soumissionRepository;

    @Autowired
    public SoumissionService(SoumissionRepository soumissionRepository) {
        this.soumissionRepository = soumissionRepository;
    }

    // Récupérer toutes les soumissions
    public List<Soumission> getSoumissions() {
        return soumissionRepository.findAll();
    }

    // Récupérer une soumission par son ID
    public Soumission getSoumissionById(Long id) {
        return soumissionRepository.findById(id).orElse(null);
    }

    // Ajouter une nouvelle soumission
    public Soumission addSoumission(Soumission soumission) {
        return soumissionRepository.save(soumission);
    }

    // Mettre à jour une soumission existante
    public Soumission updateSoumission(Soumission soumission) {
        return soumissionRepository.save(soumission);
    }

    // Supprimer une soumission
    public void deleteSoumission(Long id) {
        soumissionRepository.deleteById(id);
    }
}