package com.example.demo.repository;

import com.example.demo.domain.dto.CarDto;
import com.example.demo.domain.entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    Page<Car> findByMakerIgnoreCase(String maker, Pageable pageable);

    Page<Car> findByMakerIgnoreCaseAndModelIgnoreCaseAndYear(String maker, String model, Integer year, Pageable pageable);

}

