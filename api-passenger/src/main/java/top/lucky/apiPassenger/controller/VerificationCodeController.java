package top.lucky.apiPassenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.lucky.apiPassenger.request.VerificationCodeDto;
import top.lucky.apiPassenger.service.VerificationCodeService;
import top.lucky.common.dto.ResponseResult;

/**
 * @author Jane
 * @date 2022/10/7, 18:29
 */
@RestController
public class VerificationCodeController {
	
	@Autowired
	private VerificationCodeService verificationCodeService;
	
	@GetMapping("/verification-code")
	public ResponseResult verificationCode(@RequestBody VerificationCodeDto verificationCodeDTO) {
		String passengerPhone = verificationCodeDTO.getPassengerPhone();
		return verificationCodeService.generatorCode(passengerPhone);
	}
}
