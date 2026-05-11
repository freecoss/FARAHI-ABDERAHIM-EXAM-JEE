package org.exam.locationbackend.entities;

import jakarta.persistence.*;
import lombok.*;
import org.exam.locationbackend.enums.VehiculeStatut;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vehicules")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type_vehicule", discriminatorType = DiscriminatorType.STRING)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String marque;

    @Column(nullable = false, length = 100)
    private String modele;

    @Column(nullable = false, unique = true, length = 20)
    private String matricule;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal prixParJour;

    @Column(nullable = false)
    private LocalDate dateMiseEnService;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private VehiculeStatut statut;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "agence_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Agence agence;

    @OneToMany(mappedBy = "vehicule", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Location> locations = new ArrayList<>();
}
