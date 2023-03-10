package com.oguerrero.motoservice.services;

import com.oguerrero.motoservice.entity.Moto;
import com.oguerrero.motoservice.repository.MotoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoServiceImpl implements MotoService {

    private final MotoRepository motoRepository;

    public MotoServiceImpl(MotoRepository motoRepository) {
        this.motoRepository = motoRepository;
    }

    @Override
    public List<Moto> getAll() {
        return motoRepository.findAll();
    }

    @Override
    public Moto getById(Long id) {
        return motoRepository.findById(id).orElse(null);
    }

    @Override
    public Moto save(Moto moto) {
        return motoRepository.save(moto);
    }

    @Override
    public void delete(Long id) {
        motoRepository.deleteById(id);
    }

    @Override
    public List<Moto> byUserID(Long id) {
        return motoRepository.findByUserId(id);
    }
}
