package com.FurniLand.backend.services;

import com.FurniLand.backend.models.Furniture;
import com.FurniLand.backend.repositories.FurnitureRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FurnitureServiceImpl implements FurnitureService {

    private final FurnitureRepository furnitureRepository;
    private final String flaskApiEndpoint;

    public FurnitureServiceImpl(FurnitureRepository furnitureRepository, @Value("${flask.api.endpoint}") String flaskApiEndpoint) {
        this.furnitureRepository = furnitureRepository;
        this.flaskApiEndpoint = flaskApiEndpoint;
    }





    @Override
    public Furniture getFurniture(Long id) {
        return furnitureRepository.findById(id).orElse(null);
    }

    @Override
    public List<Furniture> getAllFurnitures() {
        return furnitureRepository.findAll();
    }


}
