package com.FurniLand.backend.RestControllers;

import com.FurniLand.backend.models.Annonce;
import com.FurniLand.backend.services.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/api/Annonces")
public class RestControllerAnnonce {
    @Autowired
    private AnnonceService annonceService;

    @PostMapping("/add-annonce")
    public ResponseEntity<Annonce> ajouterAnnonce(@RequestBody Annonce annonce) {
        try {
            System.out.println("Données reçues : " + annonce);
            Annonce savedAnnonce = annonceService.saveAnnonce(annonce);
            return new ResponseEntity<>(savedAnnonce, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/annonces-list")
    public ResponseEntity<List<Annonce>> getAllAnnonces() {
        List<Annonce> annonces = annonceService.getAllAnnonces();
        return new ResponseEntity<>(annonces, HttpStatus.OK);
    }
}
