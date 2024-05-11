package org.com.flashrent.repositories;

import org.com.flashrent.entities.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubmissionRepo extends JpaRepository<Submission, Long> {
    @Query("SELECT s FROM Submission s JOIN s.locataire t WHERE t.id = :locataireId")
    List<Submission> findByLocataireId(Long locataireId);
}
