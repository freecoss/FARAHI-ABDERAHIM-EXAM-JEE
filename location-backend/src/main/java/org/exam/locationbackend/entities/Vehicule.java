package org.exam.locationbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.exam.locationbackend.enums.VehiculeStatut;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", length = 8)
@Data @NoArgsConstructor @AllArgsConstructor
public abstract class Vehicule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marque;
    private String modele;
    private String matricule;
    private double prixParJour;
    private Date dateMiseEnService;
    @Enumerated(EnumType.STRING)
    private VehiculeStatut statut;
    @ManyToOne
    private Agence agence;
    @OneToMany(mappedBy = "vehicule", fetch = FetchType.LAZY)
    private List<Location> locations;
}
