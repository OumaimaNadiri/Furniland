package com.FurniLand.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MeubleFeatures {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Float depth;
    private Float height;
    private Float width ;

    public Float getDepth() {
        return depth;
    }

    public Float getHeight() {
        return height;
    }

    public Float getWidth() {
        return width;
    }
}
