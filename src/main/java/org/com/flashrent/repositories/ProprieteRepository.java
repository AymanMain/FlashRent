package org.com.flashrent.repositories;

import org.com.flashrent.entities.Propriete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProprieteRepository extends JpaRepository<Propriete, Long> {
    // Vous pouvez ajouter des méthodes de requête personnalisées si nécessaire
}