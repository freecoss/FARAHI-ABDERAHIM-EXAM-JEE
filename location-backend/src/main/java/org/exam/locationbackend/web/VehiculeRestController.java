package org.exam.locationbackend.web;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.exam.locationbackend.dtos.MotoDTO;
import org.exam.locationbackend.dtos.VehiculeDTO;
import org.exam.locationbackend.dtos.VoitureDTO;
import org.exam.locationbackend.exceptions.AgenceNotFoundException;
import org.exam.locationbackend.exceptions.VehiculeNotFoundException;
import org.exam.locationbackend.services.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class VehiculeRestController {
    private LocationService locationService;

    @GetMapping("/vehicules")
    public List<VehiculeDTO> vehicules() {
        return locationService.listVehicules();
    }

    @GetMapping("/vehicules/{id}")
    public VehiculeDTO getVehicule(@PathVariable(name = "id") Long vehiculeId) throws VehiculeNotFoundException {
        return locationService.getVehicule(vehiculeId);
    }

    @PostMapping("/vehicules/voitures")
    public VoitureDTO saveVoiture(@Valid @RequestBody VoitureDTO voitureDTO) throws AgenceNotFoundException {
        return locationService.saveVoiture(voitureDTO);
    }

    @PostMapping("/vehicules/motos")
    public MotoDTO saveMoto(@Valid @RequestBody MotoDTO motoDTO) throws AgenceNotFoundException {
        return locationService.saveMoto(motoDTO);
    }
}
