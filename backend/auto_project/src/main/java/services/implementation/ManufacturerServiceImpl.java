package services.implementation;

import auto.backe.auto_project.models.Manufacturer;
import repo.ManufacturerRepository;
import services.ManufacturerService;

import java.util.Optional;

public class ManufacturerServiceImpl implements ManufacturerService {

    private ManufacturerRepository manufacturerRepository;
    @Override
    public Object getAll() {
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
    public Object createManufacturer(Manufacturer manufacturer) {
        return manufacturerRepository.save(manufacturer);
    }
}
