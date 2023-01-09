package top.lucky.driveruser.service;

import top.lucky.common.dto.DriverUser;
import top.lucky.common.dto.ResponseResult;

public interface DriverUserService {
	ResponseResult addUser(DriverUser driverUser);
	
	ResponseResult updateDriverUser(DriverUser driverUser);
}
