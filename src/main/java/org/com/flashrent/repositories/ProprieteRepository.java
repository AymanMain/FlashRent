package org.com.flashrent.repositories;

import org.com.flashrent.entities.Propriete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProprieteRepository extends JpaRepository<Propriete, Long> {
    List<Propriete> findByProprietaireId(Long proprietaireId);
    List<Propriete> findByLocataireIsNull();
    @Query("SELECT p FROM Propriete p JOIN FETCH p.soumissions WHERE p.id = :id")
    Optional<Propriete> findByIdAndFetchSoumissionsEagerly(@Param("id") Long id);
}
