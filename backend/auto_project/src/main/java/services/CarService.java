package services;

import auto.backe.auto_project.models.Car;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CarService {
    Object getAll();

    public void deleteCar(Car car);

    Optional<Car> findCarById(Long id);

    Object createCar(Car car);

    void saveCar(Car existingCar);
}
