package com.user.service.feign;

import com.user.service.models.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "car-service", url = "http://localhost:8082")
@RequestMapping("/car")
public interface CarFeignClient {

    @PostMapping("")
    Car save(@RequestBody Car car);

    @GetMapping("/user/{id}")
    List<Car> getByUserId(@PathVariable Long id);
}
