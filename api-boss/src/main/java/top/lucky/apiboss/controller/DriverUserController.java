package top.lucky.apiboss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.lucky.apiboss.service.CarService;
import top.lucky.apiboss.service.DriverUserService;
import top.lucky.common.dto.Car;
import top.lucky.common.dto.DriverUser;
import top.lucky.common.dto.ResponseResult;

@RestController
public class DriverUserController {

    @Autowired
    private DriverUserService driverUserService;
    @Autowired
    private CarService carService;

    /**
     * 添加司机
     * @param driverUser
     * @return
     */
    @PostMapping("/driver-user")
    public ResponseResult addDriverUser(@RequestBody DriverUser driverUser){
        return driverUserService.addDriverUser(driverUser);
    }

    /**
     * 修改司机
     * @param driverUser
     * @return
     */
    @PutMapping("/driver-user")
    public ResponseResult updateDriverUser(@RequestBody DriverUser driverUser){
        return driverUserService.updateDriverUser(driverUser);
    }


   

    @PostMapping("/car")
    public ResponseResult car(@RequestBody Car car){
        return carService.addCar(car);
    }
}