package br.com.carstore.controller;

import br.com.carstore.dto.CarDTO;
import br.com.carstore.dto.CarResponseBody;
import br.com.carstore.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IndexController {

    private final CarService carService;

    public IndexController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/api/cars")
    public ResponseEntity<CarResponseBody> home() {

        List<CarDTO> allCars = carService.findAll();

        CarResponseBody carResponseBody = new CarResponseBody(allCars);

        return ResponseEntity.ok(carResponseBody);
    }

    @PostMapping("/api/cars")
    public ResponseEntity<CarDTO> createCar(@RequestBody CarDTO carDTO) {

        carService.save(carDTO);

        return ResponseEntity.ok(carDTO);
    }

    @DeleteMapping("/api/cars/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {

        carService.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/api/cars/{id}")
    public ResponseEntity<CarDTO> updateCar(
            @PathVariable Long id,
            @RequestBody CarDTO carDTO
    ) {

        carService.update(id, carDTO);

        return ResponseEntity.ok(carDTO);
    }
}