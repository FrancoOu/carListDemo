package com.example.demo.service;


import com.example.demo.domain.ResponseResult;

public interface CarService {

    ResponseResult getAllCars();

    ResponseResult getCarsByFilters(String maker, String model, Integer year);

    ResponseResult getCarsByMaker(String maker);
}
