package com.FurniLand.backend.repositories;

import com.FurniLand.backend.models.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FurnitureRepository extends JpaRepository<Furniture,Long> {

}
