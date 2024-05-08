package org.com.flashrent.repositories;

import org.com.flashrent.entities.Locataire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocataireRepo extends JpaRepository<Locataire, Long> {
}
