package services.implementation;

import repo.ModelRepository;
import services.ModelService;

public class ModerServiceImpl implements ModelService {

    private ModelRepository modelRepository;
    @Override
    public Object getAll() {
        return modelRepository.findAll();
    }
}
