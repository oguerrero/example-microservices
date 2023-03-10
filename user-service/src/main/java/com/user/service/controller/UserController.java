package com.user.service.controller;

import com.user.service.entity.User;
import com.user.service.models.Car;
import com.user.service.models.Moto;
import com.user.service.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAll();

        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserByID(@PathVariable Long id) {
        User user = userService.getById(id);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(user);
    }

    @PostMapping("")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User savedUser = userService.save(user);

        return ResponseEntity.ok(savedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        userService.delete(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<List<Car>> getCarsByUserId(@PathVariable Long id) {
        User user = userService.getById(id);
        List<Car> cars = userService.getCars(id);

        if (cars.isEmpty() || user == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(cars);
    }

    @GetMapping("/moto/{id}")
    public ResponseEntity<List<Moto>> getMotosByUserId(@PathVariable Long id) {
        User user = userService.getById(id);
        List<Moto> motos = userService.getMotos(id);

        if (motos.isEmpty() || user == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(motos);
    }

    @PostMapping("/car/{id}")
    public ResponseEntity<Car> saveCar(@PathVariable Long id, @RequestBody Car car) {
        Car savedCar = userService.saveCar(id, car);

        return ResponseEntity.ok(savedCar);
    }

    @PostMapping("/moto/{id}")
    public ResponseEntity<Moto> saveMoto(@PathVariable Long id, @RequestBody Moto moto) {
        Moto savedMoto = userService.saveMoto(id, moto);

        return ResponseEntity.ok(savedMoto);
    }

    @GetMapping("/car/feign/{id}")
    public ResponseEntity<List<Car>> getCarsByUserIdFeign(@PathVariable Long id) {
        User user = userService.getById(id);
        List<Car> cars = userService.getCarsFeign(id);

        if (cars.isEmpty() || user == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(cars);
    }

    @GetMapping("/moto/feign/{id}")
    public ResponseEntity<List<Moto>> getMotosByUserIdFeign(@PathVariable Long id) {
        User user = userService.getById(id);
        List<Moto> motos = userService.getMotosFeign(id);

        if (motos.isEmpty() || user == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(motos);
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<Map<String, Object>> getUserVehicles(@PathVariable Long id) {
        User user = userService.getById(id);
        Map<String, Object> vehicles = userService.getUserVehicles(id);

        if (vehicles.isEmpty() || user == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(vehicles);
    }
}
