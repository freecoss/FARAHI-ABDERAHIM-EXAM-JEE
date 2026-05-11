package org.exam.locationbackend.dtos;
import lombok.Data;
import org.exam.locationbackend.enums.VehiculeStatut;
import java.util.Date;
@Data
public class VehiculeDTO {
    private String type;
    private Long id;
    private String marque;
    private String modele;
    private String matricule;
    private double prixParJour;
    private Date dateMiseEnService;
    private VehiculeStatut statut;
    private AgenceDTO agenceDTO;
}
