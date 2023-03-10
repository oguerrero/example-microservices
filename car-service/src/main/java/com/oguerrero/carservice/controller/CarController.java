package com.oguerrero.carservice.controller;

import com.oguerrero.carservice.entity.Car;
import com.oguerrero.carservice.services.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("")
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> cars = carService.getAll();

        if (cars.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(cars);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarByID(@PathVariable Long id) {
        Car car = carService.getById(id);

        if (car == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(car);
    }

    @PostMapping("")
    public ResponseEntity<Car> saveCar(@RequestBody Car car) {
        Car savedCar = carService.save(car);

        return ResponseEntity.ok(savedCar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Car> deleteCar(@PathVariable Long id) {
        carService.delete(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping("user/{id}")
    public ResponseEntity<List<Car>> getUserCarsById(@PathVariable Long id) {
        List<Car> cars = carService.byUserID(id);

        if (cars.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(cars);
    }
}
