package com.user.service.feign;

import com.user.service.models.Moto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "moto-service", url = "http://localhost:8083")
@RequestMapping("/moto")
public interface MotoFeignClient {

    @PostMapping("")
    Moto save(@RequestBody Moto moto);

    @GetMapping("/user/{id}")
    List<Moto> getByUserId(@PathVariable Long id);
}
