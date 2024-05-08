package org.com.flashrent.repositories;
import org.com.flashrent.entities.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepo extends JpaRepository<Property, Long> {
}