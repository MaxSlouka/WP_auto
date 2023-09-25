package controllers;

import auto.backe.auto_project.models.Car;
import auto.backe.auto_project.models.Manufacturer;
import auto.backe.auto_project.models.Model;
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


    @PostMapping("/car")
    public ResponseEntity<?> createCar(@RequestBody Car car) {
        return ResponseEntity.ok(carService.createCar(car));
    }

    @PostMapping("/model")
    public ResponseEntity<?> createModel(@RequestBody Model model){
        return ResponseEntity.ok(modelService.createModel(model));
    }

    @PostMapping("/manufacturer")
    public ResponseEntity<?> createManufacturer(@RequestBody Manufacturer manufacturer){
        return ResponseEntity.ok(manufacturerService.createManufacturer(manufacturer));
    }

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
    public ResponseEntity<?> deleteCar(@PathVariable Long id) {
        Optional<Car> optionalCar = carService.findCarById(id);
        if (optionalCar.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Car car = optionalCar.get();
        carService.deleteCar(car);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/manfacturer/{id}")
    public ResponseEntity<?> deleteManufacturer(@PathVariable Long id) {
        Optional<Manufacturer> optionalManufacturer = manufacturerService.findById(id);
        if (optionalManufacturer.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Manufacturer manufacturer = optionalManufacturer.get();
        manufacturerService.deleteManufacturer(manufacturer);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/Model/{id}")
    public ResponseEntity<?> deleteModel(@PathVariable Long id){
        Optional<Model> optionalModel = modelService.findById(id);
        if (optionalModel.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Model model = optionalModel.get();
        modelService.deleteModel(model);
        return ResponseEntity.noContent().build();
    }
}
