package auto.backe.auto_project.services;

import auto.backe.auto_project.models.Car;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CarService {
    List<Car> getAll();

    void deleteCar(Car car);

    Optional<Car> findCarById(Long id);

    Car createCar(Car car);

    void updateCar(Car existingCar);

    void saveCar(Car car);
}