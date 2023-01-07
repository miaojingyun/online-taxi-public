package top.lucky.servicePassengerUser.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.lucky.common.dto.ResponseResult;
import top.lucky.common.request.VerificationCodeDto;
import top.lucky.servicePassengerUser.service.UserService;

/**
 * @author Jane
 * @date 2022/10/9, 10:58
 */
@RestController
@Slf4j
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public ResponseResult loginOrReg(@RequestBody VerificationCodeDto verificationCodeDto) {
		String passengerPhone = verificationCodeDto.getPassengerPhone();
		
		ResponseResult responseResult = userService.loginOrRegister(passengerPhone);
		log.info("passengerPhone = {}" + passengerPhone);
		return responseResult;
	}
	
	@RequestMapping("/user/{passengerPhone}")
	public ResponseResult getUserByPhone(@PathVariable("passengerPhone") String passengerPhone) {
		return userService.getUserByPhone(passengerPhone);
	}
}
