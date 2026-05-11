package org.exam.locationbackend.mappers;
import org.exam.locationbackend.dtos.*;
import org.exam.locationbackend.entities.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class LocationMapperImpl {
    public AgenceDTO fromAgence(Agence agence) {
        AgenceDTO agenceDTO = new AgenceDTO();
        BeanUtils.copyProperties(agence, agenceDTO);
        return agenceDTO;
    }
    public Agence fromAgenceDTO(AgenceDTO agenceDTO) {
        Agence agence = new Agence();
        BeanUtils.copyProperties(agenceDTO, agence);
        return agence;
    }
    
    public VoitureDTO fromVoiture(Voiture voiture) {
        VoitureDTO voitureDTO = new VoitureDTO();
        BeanUtils.copyProperties(voiture, voitureDTO);
        if(voiture.getAgence() != null) {
            voitureDTO.setAgenceDTO(fromAgence(voiture.getAgence()));
        }
        voitureDTO.setType("Voiture");
        return voitureDTO;
    }
    public Voiture fromVoitureDTO(VoitureDTO voitureDTO) {
        Voiture voiture = new Voiture();
        BeanUtils.copyProperties(voitureDTO, voiture);
        if(voitureDTO.getAgenceDTO() != null) {
            voiture.setAgence(fromAgenceDTO(voitureDTO.getAgenceDTO()));
        }
        return voiture;
    }

    public MotoDTO fromMoto(Moto moto) {
        MotoDTO motoDTO = new MotoDTO();
        BeanUtils.copyProperties(moto, motoDTO);
        if(moto.getAgence() != null) {
            motoDTO.setAgenceDTO(fromAgence(moto.getAgence()));
        }
        motoDTO.setType("Moto");
        return motoDTO;
    }
    public Moto fromMotoDTO(MotoDTO motoDTO) {
        Moto moto = new Moto();
        BeanUtils.copyProperties(motoDTO, moto);
        if(motoDTO.getAgenceDTO() != null) {
            moto.setAgence(fromAgenceDTO(motoDTO.getAgenceDTO()));
        }
        return moto;
    }

    public LocationDTO fromLocation(Location location) {
        LocationDTO locationDTO = new LocationDTO();
        BeanUtils.copyProperties(location, locationDTO);
        if (location.getVehicule() != null) {
            if (location.getVehicule() instanceof Voiture) {
                locationDTO.setVehiculeDTO(fromVoiture((Voiture) location.getVehicule()));
            } else if (location.getVehicule() instanceof Moto) {
                locationDTO.setVehiculeDTO(fromMoto((Moto) location.getVehicule()));
            }
        }
        return locationDTO;
    }
    public Location fromLocationDTO(LocationDTO locationDTO) {
        Location location = new Location();
        BeanUtils.copyProperties(locationDTO, location);
        if (locationDTO.getVehiculeDTO() != null) {
            if (locationDTO.getVehiculeDTO() instanceof VoitureDTO) {
                location.setVehicule(fromVoitureDTO((VoitureDTO) locationDTO.getVehiculeDTO()));
            } else if (locationDTO.getVehiculeDTO() instanceof MotoDTO) {
                location.setVehicule(fromMotoDTO((MotoDTO) locationDTO.getVehiculeDTO()));
            }
        }
        return location;
    }
}
