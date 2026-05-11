package org.exam.locationbackend.web;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.exam.locationbackend.dtos.LocationDTO;
import org.exam.locationbackend.exceptions.VehiculeNotFoundException;
import org.exam.locationbackend.services.LocationService;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class LocationRestController {
    private LocationService locationService;

    @PostMapping("/locations")
    public LocationDTO saveLocation(@Valid @RequestBody LocationDTO locationDTO) throws VehiculeNotFoundException {
        return locationService.saveLocation(locationDTO);
    }
}
