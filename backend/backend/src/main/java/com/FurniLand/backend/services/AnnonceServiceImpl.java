package com.FurniLand.backend.services;

import com.FurniLand.backend.models.Annonce;
import com.FurniLand.backend.repositories.AnnonceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AnnonceServiceImpl implements AnnonceService{

    private final AnnonceRepository annonceRepository;

    public AnnonceServiceImpl(AnnonceRepository annonceRepository) {
        this.annonceRepository = annonceRepository;
    }

    @Override
    public Annonce saveAnnonce(Annonce annonce) {
        return annonceRepository.save(annonce);
    }

    @Override
    public List<Annonce> getAllAnnonces() {
        return annonceRepository.findAll();
    }
}
