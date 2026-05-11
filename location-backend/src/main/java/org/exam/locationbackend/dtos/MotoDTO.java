package org.exam.locationbackend.dtos;
import lombok.Data;
import org.exam.locationbackend.enums.TypeMoto;
@Data
public class MotoDTO extends VehiculeDTO {
    private int cylindree;
    private TypeMoto typeMoto;
    private boolean casqueInclus;
}
