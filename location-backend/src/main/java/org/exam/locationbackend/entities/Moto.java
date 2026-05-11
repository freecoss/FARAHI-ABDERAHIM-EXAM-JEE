package org.exam.locationbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.exam.locationbackend.enums.TypeMoto;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
@DiscriminatorValue("MOTO")
@Data @NoArgsConstructor @AllArgsConstructor
public class Moto extends Vehicule {
    private int cylindree;
    @Enumerated(EnumType.STRING)
    private TypeMoto typeMoto;
    private boolean casqueInclus;
}
