package org.com.flashrent.services;

import org.com.flashrent.entities.Propriete;
import org.com.flashrent.repositories.ProprieteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return proprieteRepository.findById(id).orElse(null);
    }

    public Propriete addPropriete(Propriete propriete) {
        return proprieteRepository.save(propriete);
    }

    public Propriete updatePropriete(Propriete propriete) {
        return proprieteRepository.save(propriete);
    }

    public void deletePropriete(Long id) {
        proprieteRepository.deleteById(id);
    }
}