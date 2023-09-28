package auto.backe.auto_project.services.implementation;

import auto.backe.auto_project.models.Manufacturer;
import auto.backe.auto_project.services.ManufacturerService;
import auto.backe.auto_project.repo.ManufacturerRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class ManufacturerServiceImpl implements ManufacturerService {

    private ManufacturerRepository manufacturerRepository;

    @Override
    public List<Manufacturer> getAll() {
        return manufacturerRepository.findAll();
    }

    @Override
    public Optional<Manufacturer> findById(Long id) {
        return manufacturerRepository.findById(id);
    }

    @Override
    public void deleteManufacturer(Manufacturer manufacturer) {
        manufacturerRepository.delete(manufacturer);
    }

    @Override
    public Manufacturer createManufacturer(Manufacturer manufacturer) {
        return manufacturerRepository.save(manufacturer);
    }

    @Override
    public void updateManufacturer(Manufacturer existingManufacturer) {
        manufacturerRepository.save(existingManufacturer);
    }

    @Override
    public void saveManufacturer(Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);
    }
}
