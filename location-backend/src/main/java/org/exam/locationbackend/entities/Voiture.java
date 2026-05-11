package org.exam.locationbackend.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.exam.locationbackend.enums.BoiteVitesse;
import org.exam.locationbackend.enums.TypeCarburant;

@Entity
@Table(name = "voitures")
@DiscriminatorValue("VOITURE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Voiture extends Vehicule {

    @Column(nullable = false)
    private Integer nombrePortes;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private TypeCarburant typeCarburant;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private BoiteVitesse boiteVitesse;
}
