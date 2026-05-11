package org.exam.locationbackend.services;
import org.exam.locationbackend.dtos.*;
import org.exam.locationbackend.exceptions.*;
import java.util.List;

public interface LocationService {
    AgenceDTO saveAgence(AgenceDTO agenceDTO);
    List<AgenceDTO> listAgences();
    AgenceDTO getAgence(Long agenceId) throws AgenceNotFoundException;

    VoitureDTO saveVoiture(VoitureDTO voitureDTO) throws AgenceNotFoundException;
    MotoDTO saveMoto(MotoDTO motoDTO) throws AgenceNotFoundException;
    List<VehiculeDTO> listVehicules();
    VehiculeDTO getVehicule(Long vehiculeId) throws VehiculeNotFoundException;
    
    LocationDTO saveLocation(LocationDTO locationDTO) throws VehiculeNotFoundException;
}
