package org.exam.locationbackend;

import org.exam.locationbackend.entities.Agence;
import org.exam.locationbackend.entities.Location;
import org.exam.locationbackend.entities.Moto;
import org.exam.locationbackend.entities.Voiture;
import org.exam.locationbackend.enums.BoiteVitesse;
import org.exam.locationbackend.enums.TypeCarburant;
import org.exam.locationbackend.enums.TypeMoto;
import org.exam.locationbackend.enums.VehiculeStatut;
import org.exam.locationbackend.repositories.AgenceRepository;
import org.exam.locationbackend.repositories.LocationRepository;
import org.exam.locationbackend.repositories.VehiculeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class LocationBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(LocationBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner start(AgenceRepository agenceRepository,
                            VehiculeRepository vehiculeRepository,
                            LocationRepository locationRepository) {
        return args -> {
            Stream.of("Agence Casa", "Agence Rabat", "Agence Tanger").forEach(nom -> {
                Agence agence = new Agence();
                agence.setNom(nom);
                agence.setAdresse("Adresse de " + nom);
                agence.setVille(nom.replace("Agence ", ""));
                agence.setTelephone("0600000000");
                agenceRepository.save(agence);
            });

            agenceRepository.findAll().forEach(agence -> {
                Voiture voiture = new Voiture();
                voiture.setMarque("Renault");
                voiture.setModele("Clio 5");
                voiture.setMatricule(UUID.randomUUID().toString().substring(0, 8));
                voiture.setPrixParJour(300.0);
                voiture.setDateMiseEnService(new Date());
                voiture.setStatut(VehiculeStatut.Disponible);
                voiture.setNombrePortes(5);
                voiture.setTypeCarburant(TypeCarburant.Diesel);
                voiture.setBoiteVitesse(BoiteVitesse.Manuelle);
                voiture.setAgence(agence);
                vehiculeRepository.save(voiture);

                Moto moto = new Moto();
                moto.setMarque("Yamaha");
                moto.setModele("TMAX");
                moto.setMatricule(UUID.randomUUID().toString().substring(0, 8));
                moto.setPrixParJour(400.0);
                moto.setDateMiseEnService(new Date());
                moto.setStatut(VehiculeStatut.Disponible);
                moto.setCylindree(530);
                moto.setTypeMoto(TypeMoto.Scooter);
                moto.setCasqueInclus(true);
                moto.setAgence(agence);
                vehiculeRepository.save(moto);
            });

            vehiculeRepository.findAll().forEach(vehicule -> {
                for (int i = 0; i < 3; i++) {
                    Location location = new Location();
                    location.setDateDebut(new Date());
                    location.setDateFin(new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24 * (i + 1))));
                    location.setPrixTotal(vehicule.getPrixParJour() * (i + 1));
                    location.setVehicule(vehicule);
                    locationRepository.save(location);
                }
            });
        };
    }
}
