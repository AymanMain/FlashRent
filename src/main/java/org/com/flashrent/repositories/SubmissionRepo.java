package org.com.flashrent.repositories;

import org.com.flashrent.entities.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionRepo extends JpaRepository<Submission, Long> {
}