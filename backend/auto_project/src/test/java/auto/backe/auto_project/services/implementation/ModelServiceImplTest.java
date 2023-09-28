package auto.backe.auto_project.services.implementation;

import auto.backe.auto_project.models.Model;
import auto.backe.auto_project.repo.ModelRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ModelServiceImplTest {

    @Test
    void getAll() {
        ModelRepository modelRepository = Mockito.mock(ModelRepository.class);
        ModelServiceImpl modelService = new ModelServiceImpl(modelRepository);

        List<Model> expectedModels = Arrays.asList(
                new Model(),
                new Model()
        );
        when(modelRepository.findAll()).thenReturn(expectedModels);
        List<Model> actualModels = modelService.getAll();
        assertEquals(expectedModels, actualModels);
    }


    @Test
    void findById() {
        ModelRepository modelRepository = Mockito.mock(ModelRepository.class);
        ModelServiceImpl modelService = new ModelServiceImpl(modelRepository);
        Long sampleModelId = 1L;
        Model sampleModel = new Model();
        when(modelRepository.findById(sampleModelId)).thenReturn(Optional.of(sampleModel));
        Optional<Model> actualModel = modelService.findById(sampleModelId);
        assertEquals(Optional.of(sampleModel), actualModel);
    }

    @Test
    void deleteModel() {
        ModelRepository modelRepository = Mockito.mock(ModelRepository.class);
        ModelServiceImpl modelService = new ModelServiceImpl(modelRepository);
        Model sampleModel = new Model();
        when(modelRepository.findById(sampleModel.getModel_id())).thenReturn(Optional.of(sampleModel));
        modelService.deleteModel(sampleModel);
        Mockito.verify(modelRepository).delete(sampleModel);
    }

    @Test
    void createModel() {
        ModelRepository modelRepository = Mockito.mock(ModelRepository.class);
        ModelServiceImpl modelService = new ModelServiceImpl(modelRepository);
        Model sampleModel = Model.builder()
                .name("Sample Model")
                .type("Sample Type")
                .priceRange(10000)
                .yearOfProduction(2022)
                .build();

        when(modelRepository.save(sampleModel)).thenReturn(sampleModel);
        Model createdModel = modelService.createModel(sampleModel);
        verify(modelRepository).save(sampleModel);
        assertEquals(sampleModel, createdModel);
    }

    @Test
    void updateModel() {
        ModelRepository modelRepository = Mockito.mock(ModelRepository.class);

        ModelServiceImpl modelService = new ModelServiceImpl(modelRepository);

        Model existingModel = Model.builder()
                .name("Existing Model")
                .type("Existing Type")
                .priceRange(15000)
                .yearOfProduction(2021)
                .build();

        when(modelRepository.save(existingModel)).thenReturn(existingModel);

        modelService.updateModel(existingModel);

        verify(modelRepository).save(existingModel);
    }

    @Test
    void saveModel() {
        ModelRepository modelRepository = Mockito.mock(ModelRepository.class);
        ModelServiceImpl modelService = new ModelServiceImpl(modelRepository);

        Model modelToSave = Model.builder()
                .name("New Model")
                .type("New Type")
                .priceRange(20000)
                .yearOfProduction(2022)
                .build();

        when(modelRepository.save(modelToSave)).thenReturn(modelToSave);

        modelService.saveModel(modelToSave);

        verify(modelRepository).save(modelToSave);
    }
}