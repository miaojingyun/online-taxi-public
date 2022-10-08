package top.lucky.apiPassenger.request;

import lombok.Data;

/**
 * @author Jane
 * @date 2022/10/7, 18:32
 */
@Data
public class VerificationCodeDto {
	private String passengerPhone;
	private String verificationCode;
}
