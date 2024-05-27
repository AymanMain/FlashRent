package org.com.flashrent.repositories;

import org.com.flashrent.entities.Proprietaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProprietaireRepository extends JpaRepository<Proprietaire, Long> {
    Proprietaire findByEmail(String email);
}