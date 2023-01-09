package top.lucky.apiboss.service;

import top.lucky.common.dto.Car;
import top.lucky.common.dto.ResponseResult;

public interface CarService {
	ResponseResult addCar(Car car);
}
