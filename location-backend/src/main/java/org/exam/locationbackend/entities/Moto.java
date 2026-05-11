package org.exam.locationbackend.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.exam.locationbackend.enums.TypeMoto;


@Entity
@Table(name = "motos")
@DiscriminatorValue("MOTO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Moto extends Vehicule {

    @Column(nullable = false)
    private Integer cylindree;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private TypeMoto typeMoto;

    @Column(nullable = false)
    private Boolean casqueInclus;
}
