package com.user.service.services;

import com.user.service.entity.User;
import com.user.service.models.Car;
import com.user.service.models.Moto;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<User> getAll();
    List<Car> getCars(Long id);
    List<Car> getCarsFeign(Long id);
    List<Moto> getMotosFeign(Long id);
    Map<String, Object> getUserVehicles(Long id);
    List<Moto> getMotos(Long id);
    Car saveCar(Long userId, Car car);
    Moto saveMoto(Long userId, Moto moto);
    User getById(Long id);
    User save(User user);
    void delete(Long id);
}
