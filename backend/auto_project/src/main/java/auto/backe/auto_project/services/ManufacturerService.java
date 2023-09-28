package auto.backe.auto_project.services;

import auto.backe.auto_project.models.Manufacturer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ManufacturerService {
    List<Manufacturer> getAll();

    Optional<Manufacturer> findById(Long id);

    void deleteManufacturer(Manufacturer manufacturer);

    Manufacturer createManufacturer(Manufacturer manufacturer);

    void updateManufacturer(Manufacturer existingManufacturer);
    void saveManufacturer(Manufacturer manufacturer);
}
