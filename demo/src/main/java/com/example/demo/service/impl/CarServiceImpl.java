package com.example.demo.service.impl;

import com.example.demo.domain.ResponseResult;
import com.example.demo.domain.dto.CarDto;
import com.example.demo.domain.entity.Car;
import com.example.demo.repository.CarRepository;
import com.example.demo.service.CarService;
import com.example.demo.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public ResponseResult getAllCars() {
        List<Car> allCars = carRepository.findAll();
        List<CarDto> carDtos = BeanCopyUtils.copyBeanList(allCars, CarDto.class);
        return ResponseResult.okResult(carDtos);
    }

    @Override
    public ResponseResult getCarsByFilters(String maker, String model, Integer year) {
        List<Car> cars = carRepository.findByMakerIgnoreCaseAndModelIgnoreCaseAndYear(maker, model, year);
        List<CarDto> carDtos = BeanCopyUtils.copyBeanList(cars, CarDto.class);
        return ResponseResult.okResult(carDtos);
    }

    @Override
    public ResponseResult getCarsByMaker(String maker) {
        List<Car> carsByMaker = carRepository.findByMakerIgnoreCase(maker);
        List<CarDto> carDtos = BeanCopyUtils.copyBeanList(carsByMaker, CarDto.class);
        return ResponseResult.okResult(carDtos);
    }
}
