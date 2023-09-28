package auto.backe.auto_project.services.implementation;

import auto.backe.auto_project.models.Manufacturer;
import auto.backe.auto_project.repo.ManufacturerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ManufacturerServiceImplTest {

    ManufacturerRepository manufacturerRepository = Mockito.mock(ManufacturerRepository.class);

    @Test
    void getAll() {
        ManufacturerRepository manufacturerRepository = Mockito.mock(ManufacturerRepository.class);
        ManufacturerServiceImpl manufacturerService = new ManufacturerServiceImpl(manufacturerRepository);

        List<Manufacturer> expectedManufacturers = Arrays.asList(
                new Manufacturer(),
                new Manufacturer()
        );

        when(manufacturerRepository.findAll()).thenReturn(expectedManufacturers);

        List<Manufacturer> actualManufacturers = manufacturerService.getAll();

        assertEquals(expectedManufacturers, actualManufacturers);
    }


    @Test
    void findById() {
        ManufacturerRepository manufacturerRepository = Mockito.mock(ManufacturerRepository.class);
        ManufacturerServiceImpl manufacturerService = new ManufacturerServiceImpl(manufacturerRepository);

        Long sampleManufacturerId = 1L;
        Manufacturer sampleManufacturer = new Manufacturer();

        when(manufacturerRepository.findById(sampleManufacturerId)).thenReturn(Optional.of(sampleManufacturer));

        Optional<Manufacturer> actualManufacturer = manufacturerService.findById(sampleManufacturerId);

        assertEquals(Optional.of(sampleManufacturer), actualManufacturer);
    }


    @Test
    void deleteManufacturer() {
        ManufacturerRepository manufacturerRepository = Mockito.mock(ManufacturerRepository.class);
        ManufacturerServiceImpl manufacturerService = new ManufacturerServiceImpl(manufacturerRepository);

        Manufacturer manufacturerToDelete = Manufacturer.builder()
                .name("Sample Manufacturer")
                .country("Sample Country")
                .city("Sample City")
                .address("Sample Address")
                .psc(12345)
                .build();

        when(manufacturerRepository.findById(manufacturerToDelete.getManufacturer_id())).thenReturn(Optional.of(manufacturerToDelete));

        manufacturerService.deleteManufacturer(manufacturerToDelete);

        verify(manufacturerRepository).delete(manufacturerToDelete);
    }


    @Test
    void createManufacturer() {
        ManufacturerRepository manufacturerRepository = Mockito.mock(ManufacturerRepository.class);
        ManufacturerServiceImpl manufacturerService = new ManufacturerServiceImpl(manufacturerRepository);

        Manufacturer sampleManufacturer = Manufacturer.builder()
                .name("Sample Manufacturer")
                .country("Sample Country")
                .city("Sample City")
                .address("Sample Address")
                .psc(12345)
                .build();

        when(manufacturerRepository.save(sampleManufacturer)).thenReturn(sampleManufacturer);

        Manufacturer createdManufacturer = manufacturerService.createManufacturer(sampleManufacturer);

        verify(manufacturerRepository).save(sampleManufacturer);

        assertEquals(sampleManufacturer, createdManufacturer);
    }


    @Test
    void updateManufacturer() {
        Manufacturer existingManufacturer = new Manufacturer();
        existingManufacturer.setManufacturer_id(1L);
        when(manufacturerRepository.save(existingManufacturer)).thenReturn(existingManufacturer);

        ManufacturerServiceImpl manufacturerService = new ManufacturerServiceImpl(manufacturerRepository);

        manufacturerService.updateManufacturer(existingManufacturer);

        verify(manufacturerRepository).save(existingManufacturer);
    }


    @Test
    void saveManufacturer() {
        Manufacturer manufacturerToSave = new Manufacturer();

        when(manufacturerRepository.save(manufacturerToSave)).thenReturn(manufacturerToSave);

        ManufacturerServiceImpl manufacturerService = new ManufacturerServiceImpl(manufacturerRepository);

        manufacturerService.saveManufacturer(manufacturerToSave);

        verify(manufacturerRepository).save(manufacturerToSave);
    }

}