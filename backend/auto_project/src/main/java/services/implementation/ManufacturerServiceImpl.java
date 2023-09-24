package services.implementation;

import repo.ManufacturerRepository;
import services.ManufacturerService;

public class ManufacturerServiceImpl implements ManufacturerService {

    private ManufacturerRepository manufacturerRepository;
    @Override
    public Object getAll() {
        return manufacturerRepository.findAll();
    }
}
