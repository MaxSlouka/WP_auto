package services.implementation;

import auto.backe.auto_project.models.Model;
import repo.ModelRepository;
import services.ModelService;

import java.util.List;
import java.util.Optional;

public class ModerServiceImpl implements ModelService {

    private ModelRepository modelRepository;

    @Override
    public List<Model> getAll() {
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
    public Model createModel(Model model) {
         return modelRepository.save(model);
    }

    @Override
    public void updateModel(Model existingModel) {
        modelRepository.save(existingModel);
    }

    @Override
    public void saveModel(Model model) {
        modelRepository.save(model);
    }
}
