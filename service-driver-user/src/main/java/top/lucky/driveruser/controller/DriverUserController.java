package top.lucky.driveruser.controller;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	/**
	 * 修改司机
	 * @param driverUser
	 * @return
	 */
	@PutMapping("/user")
	public ResponseResult updateUser(@RequestBody DriverUser driverUser){
		log.info(JSONObject.fromObject(driverUser).toString());
		return driverUserService.updateDriverUser(driverUser);
	}
}
