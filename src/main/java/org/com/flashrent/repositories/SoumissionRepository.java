package org.com.flashrent.repositories;

import org.com.flashrent.entities.Soumission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SoumissionRepository extends JpaRepository<Soumission, Long> {
    List<Soumission> findByProprieteId(Long proprieteId);
    List<Soumission> findByLocataireId(Long locataireId);
}
