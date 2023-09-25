package services;

import auto.backe.auto_project.models.Manufacturer;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ManufacturerService {
    Object getAll();

    Optional<Manufacturer> findById(Long id);

    void deleteManufacturer(Manufacturer manufacturer);

    Object createManufacturer(Manufacturer manufacturer);
}
