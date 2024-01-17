package com.FurniLand.backend.services;

import com.FurniLand.backend.models.MeubleFeatures;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface PredictionService {

    public ResponseEntity<String> predictWithFlask(MeubleFeatures meubleFeatures);
    public ResponseEntity<String> predictWithFlask(double[] f);
}
