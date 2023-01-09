package top.lucky.driveruser.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.lucky.common.dto.DriverUser;
import top.lucky.common.dto.ResponseResult;
import top.lucky.driveruser.service.DriverUserService;

@RestController
@Slf4j
public class DriverUserController {
	@Autowired
	private DriverUserService driverUserService;
	
	@PostMapping("user")
	public ResponseResult addUser(@RequestBody DriverUser driverUser ) {
		return driverUserService.addUser(driverUser);
	}
}
