package services.implementation;

import auto.backe.auto_project.models.Car;
import repo.CarRepository;
import services.CarService;

import java.util.Optional;

public class CarServiceImpl implements CarService {
    private CarRepository carRepository;

    @Override
    public Object getAll() {
        return carRepository.findAll();
    }

    @Override
    public void deleteCar(Car car) {
        carRepository.delete(car);
    }

    @Override
    public Optional<Car> findCarById(Long id) {
        return Optional.ofNullable(carRepository.findById(id).orElse(null));
    }

    @Override
    public Object createCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void saveCar(Car existingCar) {
        carRepository.save(existingCar);
    }


}
