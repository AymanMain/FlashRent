package org.com.flashrent.services;

import org.com.flashrent.entities.Owner;
import org.com.flashrent.entities.Property;
import org.com.flashrent.repositories.OwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepo ownerRepository;

    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    public Optional<Owner> getOwnerById(Long id) {
        return ownerRepository.findById(id);
    }

    public Owner saveOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    public void deleteOwnerById(Long id) {
        ownerRepository.deleteById(id);
    }

    public void registerOwner(Owner owner) {
        ownerRepository.save(owner);
    }

    public boolean authenticateOwner(String email, String password) {
        Owner owner = ownerRepository.findByEmail(email);
        return owner != null && owner.getPassword().equals(password);
    }

    public List<Property> getOwnerProperties(Owner owner) {
        return (List<Property>) owner.getProperties();
    }

    public void save(Owner owner) {
        ownerRepository.save(owner);
    }

    public Owner findByEmail(String email) {
        return ownerRepository.findByEmail(email);
    }
}