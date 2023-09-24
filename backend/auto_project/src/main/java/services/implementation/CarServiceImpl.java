package services.implementation;

import repo.CarRepository;
import services.CarService;

public class CarServiceImpl implements CarService {
    private CarRepository carRepository;

    @Override
    public Object getAll() {
        return carRepository.findAll();
    }
}
