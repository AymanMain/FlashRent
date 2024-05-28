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

    public List<Soumission> getSoumissions() {
        return soumissionRepository.findAll();
    }

    public Soumission getSoumissionById(Long id) {
        return soumissionRepository.findById(id).orElse(null);
    }

    public Soumission addSoumission(Soumission soumission) {
        return soumissionRepository.save(soumission);
    }

    public Soumission updateSoumission(Soumission soumission) {
        return soumissionRepository.save(soumission);
    }

    public void deleteSoumission(Long id) {
        soumissionRepository.deleteById(id);
    }

    public List<Soumission> getSoumissionsByPropriete(Long proprieteId) {
        return soumissionRepository.findByProprieteId(proprieteId);
    }

    public List<Soumission> getSoumissionsByLocataire(Long locataireId) {
        return soumissionRepository.findByLocataireId(locataireId);
    }
}
