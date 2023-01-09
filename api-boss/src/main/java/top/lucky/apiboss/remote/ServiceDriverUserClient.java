package top.lucky.apiboss.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.lucky.common.dto.DriverUser;
import top.lucky.common.dto.ResponseResult;

@FeignClient("service-driver-user")
public interface ServiceDriverUserClient {
	
	@RequestMapping(method = RequestMethod.POST, value = "/user")
	ResponseResult addDriverUser(@RequestBody DriverUser driverUser);
	
	@RequestMapping(method = RequestMethod.PUT, value = "/user")
	ResponseResult updateDriverUser(@RequestBody DriverUser driverUser);
	
}