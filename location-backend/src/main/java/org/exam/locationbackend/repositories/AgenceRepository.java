package org.exam.locationbackend.repositories;

import org.exam.locationbackend.entities.Agence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgenceRepository extends JpaRepository<Agence, Long> {
}
