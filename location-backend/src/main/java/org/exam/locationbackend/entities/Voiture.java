package org.exam.locationbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.exam.locationbackend.enums.BoiteVitesse;
import org.exam.locationbackend.enums.TypeCarburant;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
@DiscriminatorValue("VOIT")
@Data @NoArgsConstructor @AllArgsConstructor
public class Voiture extends Vehicule {
    private int nombrePortes;
    @Enumerated(EnumType.STRING)
    private TypeCarburant typeCarburant;
    @Enumerated(EnumType.STRING)
    private BoiteVitesse boiteVitesse;
}
