package top.lucky.apiPassenger.service;

/**
 * @author Jane
 * @date 2022/10/7, 18:33
 */
public interface VerificationCodeService {
	
	String generatorCode(String passengerPhone);
}
