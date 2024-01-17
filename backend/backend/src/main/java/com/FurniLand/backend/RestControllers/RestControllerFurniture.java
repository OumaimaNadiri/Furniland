package com.FurniLand.backend.RestControllers;

import com.FurniLand.backend.models.Furniture;
import com.FurniLand.backend.models.MeubleFeatures;
import com.FurniLand.backend.services.FurnitureService;
import com.FurniLand.backend.services.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/api/Furnitures")
public class RestControllerFurniture {
    @Autowired
    FurnitureService furnitureService;

    @GetMapping("/meubles")
    List<Furniture> getListFurniture(){
        return furnitureService.getAllFurnitures();
    }

    @GetMapping("{idMeuble}")
    public Furniture getFurnitureById(@PathVariable("idMeuble") Long idMeuble){
        return furnitureService.getFurniture(idMeuble);
    }


    @Autowired
    private PredictionService predictionService;


   @PostMapping("/features")
   public ResponseEntity<String> receiveData(@RequestBody MeubleFeatures meubleFeatures) {
       // Stockez les données dans une variable ou effectuez un traitement ici
       System.out.println("Received data from Angular: " + meubleFeatures);

       // Convertir les données en tableau de valeurs
       double[] featuresArray = {
               meubleFeatures.getDepth(),
               meubleFeatures.getHeight(),
               meubleFeatures.getWidth()
       };

       // Faire l'appel à l'API Flask pour la prédiction
       ResponseEntity<String> flaskPredictionResponse = predictionService.predictWithFlask(featuresArray);

       return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(flaskPredictionResponse.getBody());
   }


}
