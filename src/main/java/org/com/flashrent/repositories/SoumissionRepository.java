package org.com.flashrent.repositories;

import org.com.flashrent.entities.Soumission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoumissionRepository extends JpaRepository<Soumission, Long> {
    // Ici, vous pouvez ajoutez des méthodes spécifiques pour Soumission si nécessaire.
}
