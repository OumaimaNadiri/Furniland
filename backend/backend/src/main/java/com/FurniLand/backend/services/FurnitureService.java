package com.FurniLand.backend.services;

import com.FurniLand.backend.models.Furniture;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FurnitureService {


    Furniture getFurniture(Long id);
    List<Furniture> getAllFurnitures();
}
