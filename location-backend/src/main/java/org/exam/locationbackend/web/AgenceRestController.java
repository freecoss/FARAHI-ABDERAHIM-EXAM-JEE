package org.exam.locationbackend.web;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.exam.locationbackend.dtos.AgenceDTO;
import org.exam.locationbackend.exceptions.AgenceNotFoundException;
import org.exam.locationbackend.services.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class AgenceRestController {
    private LocationService locationService;

    @GetMapping("/agences")
    public List<AgenceDTO> agences() {
        return locationService.listAgences();
    }

    @GetMapping("/agences/{id}")
    public AgenceDTO getAgence(@PathVariable(name = "id") Long agenceId) throws AgenceNotFoundException {
        return locationService.getAgence(agenceId);
    }

    @PostMapping("/agences")
    public AgenceDTO saveAgence(@Valid @RequestBody AgenceDTO agenceDTO) {
        return locationService.saveAgence(agenceDTO);
    }
}
