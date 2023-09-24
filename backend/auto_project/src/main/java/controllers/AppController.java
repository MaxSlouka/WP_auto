package controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.CarService;
import services.ManufacturerService;
import services.ModelService;

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
    }
