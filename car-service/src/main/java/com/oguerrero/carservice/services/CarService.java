package com.oguerrero.carservice.services;

import com.oguerrero.carservice.entity.Car;

import java.util.List;

public interface CarService {
    List<Car> getAll();

    Car getById(Long id);

    Car save(Car car);

    void delete(Long id);

    List<Car> byUserID(Long id);
}
