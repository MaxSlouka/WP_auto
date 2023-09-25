package services;

import auto.backe.auto_project.models.Model;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ModelService {
    List<Model> getAll();

    Optional<Model> findById(Long id);

    void deleteModel(Model model);

    Model createModel(Model model);

    void updateModel(Model existingModel);

    void saveModel(Model model);
}
