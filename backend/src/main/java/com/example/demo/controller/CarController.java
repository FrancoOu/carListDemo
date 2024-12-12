package com.example.demo.controller;


import com.example.demo.domain.ResponseResult;
import com.example.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarController {


    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseResult getCars(@RequestParam(required = false) String maker,
                                  @RequestParam(required = false) String model,
                                  @RequestParam(required = false) Integer year,
                                  @RequestParam(defaultValue = "1") Integer page,
                                  @RequestParam(defaultValue = "10") Integer size
                                  ) {

        if (maker != null && model != null && year != null) {
            return carService.getCarsByFilters(maker, model, year, page, size);
        } else if (maker != null) {
            return carService.getCarsByMaker(maker,page, size);
        } else {
            return carService.getAllCars(page, size);
        }
    }

}
