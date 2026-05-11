package org.exam.locationbackend.dtos;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.Date;
@Data
public class LocationDTO {
    private Long id;
    @NotNull(message = "La date de début est obligatoire")
    private Date dateDebut;
    @NotNull(message = "La date de fin est obligatoire")
    private Date dateFin;
    private double prixTotal;
    private VehiculeDTO vehiculeDTO;
}
