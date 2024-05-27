package org.com.flashrent.repositories;

import org.com.flashrent.entities.Locataire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocataireRepository extends JpaRepository<Locataire, Long> {
    Locataire findByEmail(String email);
}