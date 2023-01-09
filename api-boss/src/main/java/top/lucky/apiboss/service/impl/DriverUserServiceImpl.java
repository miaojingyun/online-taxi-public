package top.lucky.apiboss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lucky.apiboss.remote.ServiceDriverUserClient;
import top.lucky.apiboss.service.DriverUserService;
import top.lucky.common.dto.DriverUser;
import top.lucky.common.dto.ResponseResult;

@Service
public class DriverUserServiceImpl implements DriverUserService {
	@Autowired
	private ServiceDriverUserClient serviceDriverUserClient;
	
	public ResponseResult addDriverUser(DriverUser driverUser){
		return serviceDriverUserClient.addDriverUser(driverUser);
	}
	
	public ResponseResult updateDriverUser(DriverUser driverUser){
		return serviceDriverUserClient.updateDriverUser(driverUser);
	}
}
