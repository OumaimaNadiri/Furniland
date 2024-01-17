package com.FurniLand.backend.services;

import com.FurniLand.backend.models.MeubleFeatures;
import lombok.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class PredictionServiceImpl implements PredictionService{
    private final RestTemplate restTemplate;

   // @Value("${flask.api.endpoint}")
    private String flaskApiUrl;

    public PredictionServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
@Override
    public ResponseEntity<String> predictWithFlask(MeubleFeatures meubleFeatures) {
        // Préparer les données pour l'appel à l'API Flask
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<MeubleFeatures> requestEntity = new HttpEntity<>(meubleFeatures, headers);

        // Faire l'appel à l'API Flask
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                "http://localhost:5000/api/predict",
                HttpMethod.POST,
                requestEntity,
                String.class
        );

        // Traiter la réponse de l'API Flask ici si nécessaire

        return responseEntity;
    }

    @Override
    public ResponseEntity<String> predictWithFlask(double[] featuresArray) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Faire l'appel à l'API Flask en utilisant un tableau de valeurs
        HttpEntity<double[]> requestEntity = new HttpEntity<>(featuresArray, headers);

        // Utilisation de RestTemplate pour envoyer la requête POST à l'API Flask
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                "http://localhost:5000/api/predict",
                HttpMethod.POST,
                requestEntity,
                String.class
        );

        // Traiter la réponse de l'API Flask ici si nécessaire

        return responseEntity;
    }

}
