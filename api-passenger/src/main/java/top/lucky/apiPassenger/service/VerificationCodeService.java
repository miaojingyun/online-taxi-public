package top.lucky.apiPassenger.service;

import top.lucky.common.dto.ResponseResult;
import top.lucky.common.response.NumberCodeResponse;

/**
 * @author Jane
 * @date 2022/10/7, 18:33
 */
public interface VerificationCodeService {
	
	ResponseResult<NumberCodeResponse> generatorCode(String passengerPhone);
	
	ResponseResult verificationCheck(String passengerPhone, String verificationCode);
}
