package com.FurniLand.backend.repositories;

import com.FurniLand.backend.models.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnonceRepository extends JpaRepository<Annonce, Long> {
}
