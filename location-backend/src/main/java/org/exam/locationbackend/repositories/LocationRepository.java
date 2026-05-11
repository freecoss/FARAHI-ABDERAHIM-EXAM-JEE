package org.exam.locationbackend.repositories;

import org.exam.locationbackend.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
