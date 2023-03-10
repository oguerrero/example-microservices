package com.oguerrero.motoservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Moto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long motoId;
    private String brand;

    private String model;

    private Long userId;
}
