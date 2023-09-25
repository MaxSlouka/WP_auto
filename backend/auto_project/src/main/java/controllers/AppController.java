package controllers;

import auto.backe.auto_project.models.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.CarService;
import services.ManufacturerService;
import services.ModelService;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/app")
public class AppController {
    private final CarService carService;
    private final ManufacturerService manufacturerService;
    private final ModelService modelService;


    @GetMapping("/cars")
    public ResponseEntity<?> getCars() {
        return ResponseEntity.ok(carService.getAll());
    }

    @GetMapping("/manufacturers")
    public ResponseEntity<?> getManufacturers() {
        return ResponseEntity.ok(manufacturerService.getAll());
    }

    @GetMapping("/models")
    public ResponseEntity<?> getModels() {
        return ResponseEntity.ok(modelService.getAll());
    }

    @DeleteMapping("/car/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable Long id){
       Optional<Car> optionalCar = carService.findCarById(id);
        if (optionalCar.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Car car = optionalCar.get();
        carService.deleteCar(car);
        return ResponseEntity.noContent().build();
    }

    }
