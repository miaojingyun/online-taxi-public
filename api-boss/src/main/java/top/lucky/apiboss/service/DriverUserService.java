package top.lucky.apiboss.service;

import top.lucky.common.dto.DriverUser;
import top.lucky.common.dto.ResponseResult;

public interface DriverUserService {
	ResponseResult addDriverUser(DriverUser driverUser);
	
	ResponseResult updateDriverUser(DriverUser driverUser);
}
