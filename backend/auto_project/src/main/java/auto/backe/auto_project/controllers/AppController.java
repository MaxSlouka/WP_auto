package auto.backe.auto_project.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import auto.backe.auto_project.services.CarService;
import auto.backe.auto_project.services.ModelService;
import auto.backe.auto_project.services.ManufacturerService;
import auto.backe.auto_project.models.Car;
import auto.backe.auto_project.models.Manufacturer;
import auto.backe.auto_project.models.Model;
import auto.backe.auto_project.models.dto.CarDTO;
import auto.backe.auto_project.models.dto.ManufacturerDTO;
import auto.backe.auto_project.models.dto.ModelDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/app")
@Api(value = "App Controller", description = "Operations related to cars, manufacturers, and models")
public class AppController {
    private final CarService carService;
    private final ModelService modelService;
    private final ManufacturerService manufacturerService;

    @PostMapping("/car")
    @ApiOperation(value = "Create a new car", response = CarDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created the car"),
            @ApiResponse(code = 400, message = "Invalid car data")
    })
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
    @ApiOperation(value = "Create a new model", response = Model.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created the model"),
            @ApiResponse(code = 400, message = "Invalid model data")
    })
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
    @ApiOperation(value = "Create a new manufacturer", response = Manufacturer.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created the manufacturer"),
            @ApiResponse(code = 400, message = "Invalid manufacturer data")
    })
    public ResponseEntity<?> createManufacturer(@RequestBody Manufacturer manufacturer) {
        if (manufacturer == null ||
                manufacturer.getName() == null || manufacturer.getName().isEmpty() ||
                manufacturer.getCountry() == null || manufacturer.getCountry().isEmpty() ||
                manufacturer.getCity() == null || manufacturer.getCity().isEmpty() ||
                manufacturer.getAddress() == null || manufacturer.getAddress().isEmpty() ||
                manufacturer.getPsc() <= 0) {
            return ResponseEntity.badRequest().body("Invalid manufacturer data");
        }

        return ResponseEntity.ok(manufacturerService.createManufacturer(manufacturer));
    }


    @GetMapping("/cars")
    @ApiOperation(value = "Get a list of all cars", response = CarDTO.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the list of cars"),
            @ApiResponse(code = 400, message = "Error while fetching cars")
    })
    public ResponseEntity<?> getCars() {
        try {
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
        } catch (Exception e) {
            System.out.println("Error while fetching cars: " + e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/manufacturers")
    @ApiOperation(value = "Get a list of all manufacturers", response = ManufacturerDTO.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the list of manufacturers"),
            @ApiResponse(code = 400, message = "Error while fetching manufacturers")
    })
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
    @ApiOperation(value = "Get a list of all models", response = ModelDTO.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the list of models"),
            @ApiResponse(code = 400, message = "Error while fetching models")
    })
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

    @PutMapping("/car/update/{id}")
    @ApiOperation(value = "Update a car by ID", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Car updated successfully"),
            @ApiResponse(code = 400, message = "Invalid car data for update"),
            @ApiResponse(code = 404, message = "Car not found with the specified ID")
    })
    public ResponseEntity<?> updateCar(@RequestBody Car updatedCar, @RequestParam Long id) {
        Optional<Car> optionalCar = carService.findCarById(id);
        if (optionalCar.isEmpty()) {
            System.out.println("Car not found with ID: " + id);
            return ResponseEntity.notFound().build();
        }

        Car existingCar = optionalCar.get();

        if (updatedCar == null ||
                updatedCar.getColor() == null || updatedCar.getColor().isEmpty() ||
                updatedCar.getPerformance() <= 0 ||
                updatedCar.getConsumption() <= 0 ||
                updatedCar.getYearOfProduction() <= 0 ||
                updatedCar.getModel() == null || !updatedCar.getModel().isActive()) {
            System.out.println("Invalid car data for update");
            return ResponseEntity.badRequest().body("Invalid car data for update");
        }

        existingCar.setColor(updatedCar.getColor());
        existingCar.setPerformance(updatedCar.getPerformance());
        existingCar.setConsumption(updatedCar.getConsumption());
        existingCar.setYearOfProduction(updatedCar.getYearOfProduction());
        existingCar.setActive(updatedCar.isActive());

        carService.saveCar(existingCar);

        System.out.println("Car updated successfully");
        return ResponseEntity.ok("Car updated successfully");
    }

    @PutMapping("/manufacturer/update/{id}")
    @ApiOperation(value = "Update a manufacturer by ID", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Manufacturer updated successfully"),
            @ApiResponse(code = 400, message = "Invalid manufacturer data for update"),
            @ApiResponse(code = 404, message = "Manufacturer not found with the specified ID")
    })
    public ResponseEntity<?> updateManufacturer(@RequestBody Manufacturer updatedManufacturer, @RequestParam Long id) {
        Optional<Manufacturer> optionalManufacturer = manufacturerService.findById(id);
        if (optionalManufacturer.isEmpty()) {
            System.out.println("Manufacturer not found with ID: " + id);
            return ResponseEntity.notFound().build();
        }

        Manufacturer existingManufacturer = optionalManufacturer.get();

        if (updatedManufacturer == null ||
                updatedManufacturer.getName() == null || updatedManufacturer.getName().isEmpty() ||
                updatedManufacturer.getCountry() == null || updatedManufacturer.getCountry().isEmpty() ||
                updatedManufacturer.getCity() == null || updatedManufacturer.getCity().isEmpty() ||
                updatedManufacturer.getAddress() == null || updatedManufacturer.getAddress().isEmpty() ||
                updatedManufacturer.getPsc() <= 0) {
            System.out.println("Invalid manufacturer data for update");
            return ResponseEntity.badRequest().body("Invalid manufacturer data for update");
        }

        existingManufacturer.setName(updatedManufacturer.getName());
        existingManufacturer.setCountry(updatedManufacturer.getCountry());
        existingManufacturer.setCity(updatedManufacturer.getCity());
        existingManufacturer.setAddress(updatedManufacturer.getAddress());
        existingManufacturer.setPsc(updatedManufacturer.getPsc());

        manufacturerService.saveManufacturer(existingManufacturer);

        System.out.println("Manufacturer updated successfully");
        return ResponseEntity.ok("Manufacturer updated successfully");
    }

    @PutMapping("/model/update/{id}")
    @ApiOperation(value = "Update a model by ID", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Model updated successfully"),
            @ApiResponse(code = 400, message = "Invalid model data for update"),
            @ApiResponse(code = 404, message = "Model not found with the specified ID")
    })
    public ResponseEntity<?> updateModel(@RequestBody Model updatedModel, @RequestParam Long id) {
        Optional<Model> optionalModel = modelService.findById(id);
        if (optionalModel.isEmpty()) {
            System.out.println("Model not found with ID: " + id);
            return ResponseEntity.notFound().build();
        }

        Model existingModel = optionalModel.get();

        if (updatedModel == null ||
                updatedModel.getName() == null || updatedModel.getName().isEmpty() ||
                updatedModel.getType() == null || updatedModel.getType().isEmpty() ||
                updatedModel.getPriceRange() <= 0 ||
                updatedModel.getYearOfProduction() <= 0) {
            System.out.println("Invalid model data for update");
            return ResponseEntity.badRequest().body("Invalid model data for update");
        }

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
    @ApiOperation(value = "Delete a car by ID", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Car deleted successfully"),
            @ApiResponse(code = 404, message = "Car not found with the specified ID")
    })
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
    @ApiOperation(value = "Delete a manufacturer by ID", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Manufacturer deleted successfully"),
            @ApiResponse(code = 404, message = "Manufacturer not found with the specified ID")
    })
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
    @ApiOperation(value = "Delete a model by ID", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Model deleted successfully"),
            @ApiResponse(code = 404, message = "Model not found with the specified ID")
    })
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