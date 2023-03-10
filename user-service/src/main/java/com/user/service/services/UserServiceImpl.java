package com.user.service.services;

import com.user.service.entity.User;
import com.user.service.feign.CarFeignClient;
import com.user.service.feign.MotoFeignClient;
import com.user.service.models.Car;
import com.user.service.models.Moto;
import com.user.service.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;
    private final CarFeignClient carFeignClient;
    private final MotoFeignClient motoFeignClient;

    public UserServiceImpl(UserRepository userRepository, RestTemplate restTemplate, CarFeignClient carFeignClient, MotoFeignClient motoFeignClient) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
        this.carFeignClient = carFeignClient;
        this.motoFeignClient = motoFeignClient;
    }


    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public List<Car> getCars(Long id) {
        return restTemplate.getForObject("http://localhost:8082/car/user/" + id, List.class);
    }

    @Override
    public List<Car> getCarsFeign(Long id) {
        return carFeignClient.getByUserId(id);
    }

    @Override
    public List<Moto> getMotosFeign(Long id) {
        return motoFeignClient.getByUserId(id);
    }

    @Override
    public Map<String, Object> getUserVehicles(Long id) {
        Map<String, Object> result = new HashMap<>();

        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            result.put("ERROR", "User not found");

            return result;
        }

        result.put("user", user);

        List<Car> cars = carFeignClient.getByUserId(id);

        if (cars.isEmpty()) {
            result.put("Cars", "No cars found for this user");
        } else
            result.put("cars", cars);

        List<Moto> motos = motoFeignClient.getByUserId(id);

        if (motos.isEmpty()) {
            result.put("Motos", "No motorcycles found for this user");
        } else
            result.put("motos", motos);

        return result;
    }

    @Override
    public List<Moto> getMotos(Long id) {
        return restTemplate.getForObject("http://localhost:8083/moto/user/" + id, List.class);
    }

    @Override
    public Car saveCar(Long userId, Car car) {
        car.setUserId(userId);

        return carFeignClient.save(car);
    }

    @Override
    public Moto saveMoto(Long userId, Moto moto) {
        moto.setUserId(userId);

        return motoFeignClient.save(moto);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
