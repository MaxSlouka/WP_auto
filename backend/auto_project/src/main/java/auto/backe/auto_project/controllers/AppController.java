package auto.backe.auto_project.controllers;

import auto.backe.auto_project.models.Car;
import auto.backe.auto_project.models.Manufacturer;
import auto.backe.auto_project.models.Model;
import auto.backe.auto_project.models.dto.CarDTO;
import auto.backe.auto_project.models.dto.ManufacturerDTO;
import auto.backe.auto_project.models.dto.ModelDTO;
import auto.backe.auto_project.services.CarService;
import auto.backe.auto_project.services.ManufacturerService;
import auto.backe.auto_project.services.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/app")
public class AppController {
    private final CarService carService;
    private final ModelService modelService;
    private final ManufacturerService manufacturerService;

    @PostMapping("/car")
    public ResponseEntity<?> createCar(@RequestBody Car car) {
        if (car == null ||
                car.getColor() == null || car.getColor().isEmpty() ||
                car.getPerformance() <= 0 ||
                car.getConsumption() <= 0 ||
                car.getYearOfProduction() <= 0 ||
                car.getModel() == null || !car.getModel().isActive()) {
            return ResponseEntity.badRequest().body("Invalid car data");
        }

        return ResponseEntity.ok(carService.createCar(car));
    }


    @PostMapping("/model")
    public ResponseEntity<?> createModel(@RequestBody Model model) {
        if (model == null ||
                model.getName() == null || model.getName().isEmpty() ||
                model.getType() == null || model.getType().isEmpty() ||
                model.getPriceRange() <= 0 ||
                model.getYearOfProduction() <= 0) {
            return ResponseEntity.badRequest().body("Invalid model data");
        }

        return ResponseEntity.ok(modelService.createModel(model));
    }


    @PostMapping("/manufacturer")
    public ResponseEntity<?> createManufacturer(@RequestBody Manufacturer manufacturer) {
        return ResponseEntity.ok(manufacturerService.createManufacturer(manufacturer));
    }

    @GetMapping("/cars")
    public ResponseEntity<?> getCars() {
        try{
            List<Car> cars = carService.getAll();
            List<CarDTO> carDTOS = new ArrayList<>();
            for (Car car : cars) {
                CarDTO carDTO = new CarDTO();
                carDTO.setColor(car.getColor());
                carDTO.setPerformance(car.getPerformance());
                carDTO.setConsumption(car.getConsumption());
                carDTO.setYearOfProduction(car.getYearOfProduction());
                carDTO.setActive(car.isActive());
                carDTO.setModel(car.getModel().getName());
                carDTOS.add(carDTO);
                System.out.println("Processing car: " + carDTO.getModel());
            }
            System.out.println("Successfully fetched cars");
            return ResponseEntity.ok(carDTOS);
        } catch (Exception e){
            System.out.println("Error while fetching cars: " + e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/manufacturers")
    public ResponseEntity<?> getManufacturers() {
        try {
            List<Manufacturer> manufacturers = manufacturerService.getAll();
            List<ManufacturerDTO> manufacturerDTOS = new ArrayList<>();
            for (Manufacturer manufacturer : manufacturers) {
                ManufacturerDTO manufacturerDTO = new ManufacturerDTO();
                manufacturerDTO.setName(manufacturer.getName());
                manufacturerDTO.setCountry(manufacturer.getCountry());
                manufacturerDTO.setCity(manufacturer.getCity());
                manufacturerDTO.setAddress(manufacturer.getAddress());
                manufacturerDTO.setPsc(manufacturer.getPsc());
                manufacturerDTOS.add(manufacturerDTO);
                System.out.println("Processing manufacturer: " + manufacturerDTO.getName());
            }
            System.out.println("Successfully fetched manufacturers");
            return ResponseEntity.ok(manufacturerDTOS);
        } catch (Exception e) {
            System.out.println("Error while fetching manufacturers: " + e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/models")
    public ResponseEntity<?> getModels() {
        try {
            List<Model> models = modelService.getAll();
            List<ModelDTO> modelDTOS = new ArrayList<>();
            for (Model model : models) {
                ModelDTO modelDTO = new ModelDTO();
                modelDTO.setName(model.getName());
                modelDTO.setActive(model.isActive());
                modelDTO.setType(model.getType());
                modelDTO.setPriceRange(model.getPriceRange());
                modelDTO.setYearOfProduction(model.getYearOfProduction());
                modelDTOS.add(modelDTO);
                System.out.println("Processing model: " + modelDTO.getName());
            }
            System.out.println("Successfully fetched models");
            return ResponseEntity.ok(modelDTOS);
        } catch (Exception e) {
            System.out.println("Error while fetching models: " + e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("car/update/{id}")
    public ResponseEntity<?> updateCar(@RequestBody Car updatedCar, @RequestParam Long id) {
        Optional<Car> optionalCar = carService.findCarById(id);
        if (optionalCar.isEmpty()) {
            System.out.println("Car not found with ID: " + id);
            return ResponseEntity.notFound().build();
        }
        Car existingCar = optionalCar.get();
        existingCar.setColor(updatedCar.getColor());
        existingCar.setPerformance(updatedCar.getPerformance());
        existingCar.setConsumption(updatedCar.getConsumption());
        existingCar.setYearOfProduction(updatedCar.getYearOfProduction());
        existingCar.setActive(updatedCar.isActive());
        carService.saveCar(existingCar);
        System.out.println("Car updated successfully");
        return ResponseEntity.ok("Car updated successfully");
    }

    @PutMapping("manufacturer/update/{id}")
    public ResponseEntity<?> updateManufacturer(@RequestBody Manufacturer updatedManufacturer, @RequestParam Long id){
        Optional<Manufacturer> optionalManufacturer = manufacturerService.findById(id);
        if (optionalManufacturer.isEmpty()){
            System.out.println("Manufacturer not found with ID: " + id);
            return ResponseEntity.notFound().build();
        }
        Manufacturer existingManufacturer = optionalManufacturer.get();
        existingManufacturer.setName(updatedManufacturer.getName());
        existingManufacturer.setCountry(updatedManufacturer.getCountry());
        existingManufacturer.setCity(updatedManufacturer.getCity());
        existingManufacturer.setAddress(updatedManufacturer.getAddress());
        existingManufacturer.setPsc(updatedManufacturer.getPsc());
        manufacturerService.saveManufacturer(existingManufacturer);
        System.out.println("Manufacturer updated successfully");
        return ResponseEntity.ok("Manufacturer updated successfully");
    }

    @PutMapping("model/update/{id}")
    public ResponseEntity<?> updateModel(@RequestBody Model updatedModel, @RequestParam Long id){
        Optional<Model> optionalModel = modelService.findById(id);
        if (optionalModel.isEmpty()){
            System.out.println("Model not found with ID: " + id);
            return ResponseEntity.notFound().build();
        }
        Model existingModel = optionalModel.get();
        existingModel.setName(updatedModel.getName());
        existingModel.setActive(updatedModel.isActive());
        existingModel.setType(updatedModel.getType());
        existingModel.setPriceRange(updatedModel.getPriceRange());
        existingModel.setYearOfProduction(updatedModel.getPriceRange());
        modelService.saveModel(existingModel);
        System.out.println("Model updated successfully");
        return ResponseEntity.ok("Model updated successfully");
    }

    @DeleteMapping("/car/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable Long id) {
        Optional<Car> optionalCar = carService.findCarById(id);
        if (optionalCar.isEmpty()) {
            System.out.println("Car not found with ID: " + id);
            return ResponseEntity.notFound().build();
        }
        Car car = optionalCar.get();
        carService.deleteCar(car);
        System.out.println("Car deleted successfully");
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/manufacturer/{id}")
    public ResponseEntity<?> deleteManufacturer(@PathVariable Long id) {
        Optional<Manufacturer> optionalManufacturer = manufacturerService.findById(id);
        if (optionalManufacturer.isEmpty()) {
            System.out.println("Manufacturer not found with ID: " + id);
            return ResponseEntity.notFound().build();
        }
        Manufacturer manufacturer = optionalManufacturer.get();
        manufacturerService.deleteManufacturer(manufacturer);
        System.out.println("Manufacturer deleted successfully");
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/model/{id}")
    public ResponseEntity<?> deleteModel(@PathVariable Long id) {
        Optional<Model> optionalModel = modelService.findById(id);
        if (optionalModel.isEmpty()) {
            System.out.println("Model not found with ID: " + id);
            return ResponseEntity.notFound().build();
        }
        Model model = optionalModel.get();
        modelService.deleteModel(model);
        System.out.println("Model deleted successfully");
        return ResponseEntity.noContent().build();
    }
}
