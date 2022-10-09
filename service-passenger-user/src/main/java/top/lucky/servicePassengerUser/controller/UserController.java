package top.lucky.servicePassengerUser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.lucky.common.dto.ResponseResult;
import top.lucky.common.request.VerificationCodeDto;
import top.lucky.servicePassengerUser.service.UserService;

/**
 * @author Jane
 * @date 2022/10/9, 10:58
 */
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("user")
	public ResponseResult loginOrReg(@RequestBody VerificationCodeDto verificationCodeDto) {
		String passengerPhone = verificationCodeDto.getPassengerPhone();
		
		ResponseResult responseResult = userService.loginOrRegister(passengerPhone);
		System.out.println("passengerPhone = " + passengerPhone);
		return responseResult;
	}
}
