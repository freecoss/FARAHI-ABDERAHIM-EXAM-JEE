package org.exam.locationbackend.dtos;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.exam.locationbackend.enums.VehiculeStatut;
import java.util.Date;
@Data
public class VehiculeDTO {
    private String type;
    private Long id;
    @NotEmpty(message = "La marque est obligatoire")
    private String marque;
    @NotEmpty(message = "Le modèle est obligatoire")
    private String modele;
    @NotEmpty(message = "Le matricule est obligatoire")
    private String matricule;
    @Min(value = 1, message = "Le prix par jour doit être positif")
    private double prixParJour;
    private Date dateMiseEnService;
    private VehiculeStatut statut;
    private AgenceDTO agenceDTO;
}
