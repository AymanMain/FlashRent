package org.com.flashrent.services;

import org.com.flashrent.entities.Locataire;
import org.com.flashrent.entities.Owner;
import org.com.flashrent.repositories.LocataireRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocataireService {
    @Autowired
    private LocataireRepo locataireRepository;

//    public List<Locataire> getAllLocataires() {
//        return locataireRepository.findAll();
//    }
//
//    public Optional<Locataire> getLocataireById(Long id) {
//        return locataireRepository.findById(id);
//    }
//
//    public Locataire saveLocataire(Locataire locataire) {
//        return locataireRepository.save(locataire);
//    }
//
//    public void deleteLocataireById(Long id) {
//        locataireRepository.deleteById(id);
//    }

    public boolean authenticateLocataire(String email, String password) {
        Optional<Locataire> locataireOptional = locataireRepository.findByEmail(email);
        return locataireOptional.isPresent() && locataireOptional.get().getMotDePasse().equals(password);
    }

    public void registerLocataire(Locataire locataire) {
        locataireRepository.save(locataire);
    }
    public void save(Locataire locataire) {
        locataireRepository.save(locataire);
    }

    public Locataire findByEmail(String email) {
        return locataireRepository.findByEmail(email).orElse(null);
    }
}
