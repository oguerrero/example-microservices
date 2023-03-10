package com.oguerrero.motoservice.services;

import com.oguerrero.motoservice.entity.Moto;

import java.util.List;

public interface MotoService {
    List<Moto> getAll();

    Moto getById(Long id);

    Moto save(Moto moto);

    void delete(Long id);

    List<Moto> byUserID(Long id);
}

