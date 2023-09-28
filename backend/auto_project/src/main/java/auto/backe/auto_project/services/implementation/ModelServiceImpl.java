package auto.backe.auto_project.services.implementation;

import auto.backe.auto_project.models.Model;
import auto.backe.auto_project.repo.ModelRepository;
import auto.backe.auto_project.services.ModelService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class ModelServiceImpl implements ModelService {

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
