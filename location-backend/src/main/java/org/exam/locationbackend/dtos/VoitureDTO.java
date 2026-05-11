package org.exam.locationbackend.dtos;
import lombok.Data;
import org.exam.locationbackend.enums.BoiteVitesse;
import org.exam.locationbackend.enums.TypeCarburant;
@Data
public class VoitureDTO extends VehiculeDTO {
    private int nombrePortes;
    private TypeCarburant typeCarburant;
    private BoiteVitesse boiteVitesse;
}
