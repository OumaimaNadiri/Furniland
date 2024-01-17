package com.FurniLand.backend.services;

import com.FurniLand.backend.models.Annonce;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AnnonceService {
    Annonce saveAnnonce(Annonce annonce);
    List<Annonce> getAllAnnonces();
}