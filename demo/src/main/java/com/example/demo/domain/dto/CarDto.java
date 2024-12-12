package com.example.demo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * DTO for {@link com.example.demo.domain.entity.Car}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDto{
     String maker;
     String model;
     Integer year;
     BigDecimal price;
     String color;
     Integer mileage;
}