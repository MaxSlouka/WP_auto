package auto.backe.auto_project.services.implementation;

import auto.backe.auto_project.models.Car;
import auto.backe.auto_project.models.Model;
import auto.backe.auto_project.repo.CarRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CarServiceImplTest {

    @Test
    void getAll() {
        CarRepository carRepository = Mockito.mock(CarRepository.class);
        CarServiceImpl carService = new CarServiceImpl(carRepository);

        List<Car> expectedCars = Arrays.asList(
                Car.builder()
                        .id(1L)
                        .model(new Model())
                        .color("Red")
                        .performance(200)
                        .consumption(8)
                        .yearOfProduction(2022)
                        .isActive(true)
                        .build(),
                Car.builder()
                        .id(2L)
                        .model(new Model())
                        .color("Blue")
                        .performance(180)
                        .consumption(10)
                        .yearOfProduction(2021)
                        .isActive(false)
                        .build()
        );

        when(carRepository.findAll()).thenReturn(expectedCars);
        List<Car> actualCars = carService.getAll();
        assertEquals(expectedCars, actualCars);
    }

    @Test
    void deleteCar() {
        CarRepository carRepository = Mockito.mock(CarRepository.class);
        CarServiceImpl carService = new CarServiceImpl(carRepository);
        Car carToDelete = Car.builder()
                .id(1L)
                .model(new Model())
                .color("Red")
                .performance(200)
                .consumption(8)
                .yearOfProduction(2022)
                .isActive(true)
                .build();

        when(carRepository.findById(carToDelete.getId())).thenReturn(Optional.of(carToDelete));

        carService.deleteCar(carToDelete);

        Mockito.verify(carRepository).delete(carToDelete);
    }




    @Test
    void findCarById() {
        CarRepository carRepository = Mockito.mock(CarRepository.class);
        CarServiceImpl carService = new CarServiceImpl(carRepository);
        Car expectedCar = Car.builder()
                .id(1L)
                .model(new Model())
                .color("Red")
                .performance(200)
                .consumption(8)
                .yearOfProduction(2022)
                .isActive(true)
                .build();

        when(carRepository.findById(expectedCar.getId())).thenReturn(Optional.of(expectedCar));

        Optional<Car> actualCar = carService.findCarById(expectedCar.getId());

        assertEquals(expectedCar, actualCar.get());
    }

    @Test
    void createCar() {
        CarRepository carRepository = Mockito.mock(CarRepository.class);
        CarServiceImpl carService = new CarServiceImpl(carRepository);
        Car expectedCar = Car.builder()
                .id(1L)
                .model(new Model())
                .color("Red")
                .performance(200)
                .consumption(8)
                .yearOfProduction(2022)
                .isActive(true)
                .build();

        when(carRepository.save(expectedCar)).thenReturn(expectedCar);

        Car actualCar = carService.createCar(expectedCar);

        assertEquals(expectedCar, actualCar);
    }

    @Test
    void updateCar() {
        CarRepository carRepository = Mockito.mock(CarRepository.class);
        CarServiceImpl carService = new CarServiceImpl(carRepository);
        Car expectedCar = Car.builder()
                .id(1L)
                .model(new Model())
                .color("Red")
                .performance(200)
                .consumption(8)
                .yearOfProduction(2022)
                .isActive(true)
                .build();

        when(carRepository.save(expectedCar)).thenReturn(expectedCar);

        carService.updateCar(expectedCar);

        Mockito.verify(carRepository).save(expectedCar);
    }

    @Test
    void saveCar() {
        CarRepository carRepository = Mockito.mock(CarRepository.class);
        CarServiceImpl carService = new CarServiceImpl(carRepository);
        Car expectedCar = Car.builder()
                .id(1L)
                .model(new Model())
                .color("Red")
                .performance(200)
                .consumption(8)
                .yearOfProduction(2022)
                .isActive(true)
                .build();

        when(carRepository.save(expectedCar)).thenReturn(expectedCar);

        carService.saveCar(expectedCar);

        Mockito.verify(carRepository).save(expectedCar);
    }
}