package com.user.service.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Moto {

    private String brand;
    private String model;
    private Long userId;
}
