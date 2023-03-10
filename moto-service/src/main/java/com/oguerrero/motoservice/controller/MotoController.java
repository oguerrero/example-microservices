package com.oguerrero.motoservice.controller;

import com.oguerrero.motoservice.entity.Moto;
import com.oguerrero.motoservice.services.MotoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moto")
public class MotoController {

    private final MotoService motoService;

    public MotoController(MotoService motoService) {
        this.motoService = motoService;
    }

    @GetMapping("")
    public ResponseEntity<List<Moto>> getAllMotos() {
        List<Moto> motos = motoService.getAll();

        if (motos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(motos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Moto> getMotoByID(@PathVariable Long id) {
        Moto moto = motoService.getById(id);

        if (moto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(moto);
    }

    @PostMapping("")
    public ResponseEntity<Moto> saveMoto(@RequestBody Moto moto) {
        Moto savedMoto = motoService.save(moto);

        return ResponseEntity.ok(savedMoto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Moto> deleteMoto(@PathVariable Long id) {
        motoService.delete(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping("user/{id}")
    public ResponseEntity<List<Moto>> getUserMotosById(@PathVariable Long id) {
        List<Moto> motos = motoService.byUserID(id);

        if (motos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(motos);
    }
}
