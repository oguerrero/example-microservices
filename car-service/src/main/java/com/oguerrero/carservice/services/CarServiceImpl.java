package com.oguerrero.carservice.services;

import com.oguerrero.carservice.entity.Car;
import com.oguerrero.carservice.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public Car getById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    @Override
    public Car save(Car user) {
        return carRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public List<Car> byUserID(Long id) {
        return carRepository.findByUserId(id);
    }
}
