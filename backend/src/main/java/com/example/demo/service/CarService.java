package com.example.demo.service;


import com.example.demo.domain.ResponseResult;

public interface CarService {

    ResponseResult getAllCars(Integer page, Integer size);

    ResponseResult getCarsByFilters(String maker, String model, Integer year, Integer page, Integer size);

    ResponseResult getCarsByMaker(String maker, Integer page, Integer size);
}
