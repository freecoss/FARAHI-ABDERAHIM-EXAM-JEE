package org.exam.locationbackend.services;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.exam.locationbackend.dtos.*;
import org.exam.locationbackend.entities.*;
import org.exam.locationbackend.exceptions.*;
import org.exam.locationbackend.mappers.LocationMapperImpl;
import org.exam.locationbackend.repositories.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class LocationServiceImpl implements LocationService {
    private AgenceRepository agenceRepository;
    private VehiculeRepository vehiculeRepository;
    private LocationRepository locationRepository;
    private LocationMapperImpl dtoMapper;

    @Override
    public AgenceDTO saveAgence(AgenceDTO agenceDTO) {
        log.info("Saving new Agence");
        Agence agence = dtoMapper.fromAgenceDTO(agenceDTO);
        Agence savedAgence = agenceRepository.save(agence);
        return dtoMapper.fromAgence(savedAgence);
    }

    @Override
    public List<AgenceDTO> listAgences() {
        return agenceRepository.findAll().stream()
                .map(agence -> dtoMapper.fromAgence(agence))
                .collect(Collectors.toList());
    }

    @Override
    public AgenceDTO getAgence(Long agenceId) throws AgenceNotFoundException {
        Agence agence = agenceRepository.findById(agenceId)
                .orElseThrow(() -> new AgenceNotFoundException("Agence not found"));
        return dtoMapper.fromAgence(agence);
    }

    @Override
    public VoitureDTO saveVoiture(VoitureDTO voitureDTO) throws AgenceNotFoundException {
        log.info("Saving new Voiture");
        if (voitureDTO.getAgenceDTO() == null || voitureDTO.getAgenceDTO().getId() == null) {
            throw new AgenceNotFoundException("Agence ID is required");
        }
        Agence agence = agenceRepository.findById(voitureDTO.getAgenceDTO().getId())
                .orElseThrow(() -> new AgenceNotFoundException("Agence not found"));
        
        Voiture voiture = dtoMapper.fromVoitureDTO(voitureDTO);
        voiture.setAgence(agence);
        Voiture savedVoiture = vehiculeRepository.save(voiture);
        return dtoMapper.fromVoiture(savedVoiture);
    }

    @Override
    public MotoDTO saveMoto(MotoDTO motoDTO) throws AgenceNotFoundException {
        log.info("Saving new Moto");
        if (motoDTO.getAgenceDTO() == null || motoDTO.getAgenceDTO().getId() == null) {
            throw new AgenceNotFoundException("Agence ID is required");
        }
        Agence agence = agenceRepository.findById(motoDTO.getAgenceDTO().getId())
                .orElseThrow(() -> new AgenceNotFoundException("Agence not found"));
        
        Moto moto = dtoMapper.fromMotoDTO(motoDTO);
        moto.setAgence(agence);
        Moto savedMoto = vehiculeRepository.save(moto);
        return dtoMapper.fromMoto(savedMoto);
    }

    @Override
    public List<VehiculeDTO> listVehicules() {
        return vehiculeRepository.findAll().stream().map(vehicule -> {
            if (vehicule instanceof Voiture) {
                return dtoMapper.fromVoiture((Voiture) vehicule);
            } else {
                return dtoMapper.fromMoto((Moto) vehicule);
            }
        }).collect(Collectors.toList());
    }

    @Override
    public VehiculeDTO getVehicule(Long vehiculeId) throws VehiculeNotFoundException {
        Vehicule vehicule = vehiculeRepository.findById(vehiculeId)
                .orElseThrow(() -> new VehiculeNotFoundException("Vehicule not found"));
        if (vehicule instanceof Voiture) {
            return dtoMapper.fromVoiture((Voiture) vehicule);
        } else {
            return dtoMapper.fromMoto((Moto) vehicule);
        }
    }

    @Override
    public LocationDTO saveLocation(LocationDTO locationDTO) throws VehiculeNotFoundException {
        log.info("Saving new Location");
        if (locationDTO.getVehiculeDTO() == null || locationDTO.getVehiculeDTO().getId() == null) {
            throw new VehiculeNotFoundException("Vehicule ID is required");
        }
        Vehicule vehicule = vehiculeRepository.findById(locationDTO.getVehiculeDTO().getId())
                .orElseThrow(() -> new VehiculeNotFoundException("Vehicule not found"));
        
        Location location = dtoMapper.fromLocationDTO(locationDTO);
        location.setVehicule(vehicule);
        Location savedLocation = locationRepository.save(location);
        return dtoMapper.fromLocation(savedLocation);
    }
}
