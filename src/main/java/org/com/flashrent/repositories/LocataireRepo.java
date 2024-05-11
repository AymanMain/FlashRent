package org.com.flashrent.repositories;

import org.com.flashrent.entities.Locataire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocataireRepo extends JpaRepository<Locataire, Long> {
    Optional<Locataire> findByEmail(String email); // Rename method to findByEmail
}
