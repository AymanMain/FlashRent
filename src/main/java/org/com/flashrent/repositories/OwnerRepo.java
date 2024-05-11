package org.com.flashrent.repositories;
import org.com.flashrent.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepo extends JpaRepository<Owner, Long> {
    Owner findByEmail(String email);
}