package services;

import auto.backe.auto_project.models.Model;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ModelService {
    Object getAll();

    Optional<Model> findById(Long id);

    void deleteModel(Model model);

    Object createModel(Model model);
}
