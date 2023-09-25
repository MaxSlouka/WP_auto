package services.implementation;

import auto.backe.auto_project.models.Model;
import repo.ModelRepository;
import services.ModelService;

import java.util.Optional;

public class ModerServiceImpl implements ModelService {

    private ModelRepository modelRepository;
    @Override
    public Object getAll() {
        return modelRepository.findAll();
    }

    @Override
    public Optional<Model> findById(Long id) {
       return modelRepository.findById(id);
    }

    @Override
    public void deleteModel(Model model) {
        modelRepository.delete(model);
    }

    @Override
    public Object createModel(Model model) {
        return modelRepository.save(model);
    }
}
