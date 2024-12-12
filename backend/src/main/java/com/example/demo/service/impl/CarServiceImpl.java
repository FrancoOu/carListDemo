package com.example.demo.service.impl;

import com.example.demo.domain.ResponseResult;
import com.example.demo.domain.dto.CarDto;
import com.example.demo.domain.dto.PaginatedCarDto;
import com.example.demo.domain.entity.Car;
import com.example.demo.repository.CarRepository;
import com.example.demo.service.CarService;
import com.example.demo.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public ResponseResult getAllCars(Integer page, Integer size) {
        // Create a pagable object
        PageRequest pageRequest = PageRequest.of(page - 1, size);


        Page<Car> carPage = carRepository.findAll(pageRequest);
        List<CarDto> carDtos = BeanCopyUtils.copyBeanList(carPage.getContent(), CarDto.class);
        return ResponseResult.okResult(new PaginatedCarDto(carDtos, carPage.getTotalPages()));
    }

    @Override
    public ResponseResult getCarsByFilters(String maker, String model, Integer year, Integer page, Integer size) {
        // Create a pagable object
        PageRequest pageRequest = PageRequest.of(page - 1, size);

        Page<Car> carPage = carRepository.findByMakerIgnoreCaseAndModelIgnoreCaseAndYear(maker, model, year, pageRequest);
        List<CarDto> carDtos = BeanCopyUtils.copyBeanList(carPage.getContent(), CarDto.class);
        return ResponseResult.okResult(new PaginatedCarDto(carDtos, carPage.getTotalPages()));
    }

    @Override
    public ResponseResult getCarsByMaker(String maker, Integer page, Integer size) {
        // Create a pagable object
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        Page<Car> carPage = carRepository.findByMakerIgnoreCase(maker, pageRequest);
        List<CarDto> carDtos = BeanCopyUtils.copyBeanList(carPage.getContent(), CarDto.class);
        return ResponseResult.okResult(new PaginatedCarDto(carDtos, carPage.getTotalPages()));
    }
}
