package auto.backe.auto_project.services.implementation;

import auto.backe.auto_project.models.Car;
import auto.backe.auto_project.services.CarService;
import auto.backe.auto_project.repo.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    private CarRepository carRepository;


    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public void deleteCar(Car car) {
        carRepository.delete(car);
    }

    @Override
    public Optional<Car> findCarById(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void updateCar(Car existingCar) {
        carRepository.save(existingCar);
    }

    @Override
    public void saveCar(Car car) {
        carRepository.save(car);
    }
}
