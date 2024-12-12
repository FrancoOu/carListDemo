package com.example.demo.repository;

import com.example.demo.domain.dto.CarDto;
import com.example.demo.domain.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByMakerIgnoreCase(String maker);

    List<Car> findByMakerIgnoreCaseAndModelIgnoreCaseAndYear(String maker, String model, Integer year);
}

