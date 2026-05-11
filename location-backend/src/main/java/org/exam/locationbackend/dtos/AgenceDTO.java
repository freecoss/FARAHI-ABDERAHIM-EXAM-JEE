package org.exam.locationbackend.dtos;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
@Data
public class AgenceDTO {
    private Long id;
    @NotEmpty(message = "Le nom ne peut pas être vide")
    private String nom;
    @NotEmpty(message = "L'adresse est obligatoire")
    private String adresse;
    @NotEmpty(message = "La ville est obligatoire")
    private String ville;
    @NotEmpty(message = "Le téléphone est obligatoire")
    private String telephone;
}
